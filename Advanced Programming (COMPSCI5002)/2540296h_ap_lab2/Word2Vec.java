import cli.ProgressBar;
import multiset.Context;
import multiset.MultiSet;
import multiset.SetElement;

import java.io.*;
import java.util.*;

public class Word2Vec {
    String inputPath;
    String outputPath;
    int k = 5;
    Context context = new Context();

    public Word2Vec(String init) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(init));
            inputPath = (String) properties.get("input.text.file");
            outputPath = (String) properties.get("wvec.out.file");
            k = Integer.parseInt((String) properties.get("wvec.k"));
            processFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Word2Vec(String inputPath, String outputPath, int k, Context context) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.k = k;
        this.context = context;
    }

    public void processFile() {
        try {
            File filename = new File(inputPath);
            FileReader reader = new FileReader(filename.getAbsolutePath());
            BufferedReader buffer = new BufferedReader(reader);
            ArrayList<String> temp = new ArrayList<>();
            String line;
            System.out.println("Reading the files...");

            // Stopwords
            HashSet<String> stopWords = new HashSet<>();
            File stopFile = new File("stop.txt");
            FileReader stopReader = new FileReader(stopFile.getAbsolutePath());
            Scanner stopScanner = new Scanner(stopReader);
            while (stopScanner.hasNextLine()) {
                stopWords.add(stopScanner.nextLine().replace("'", ""));
            }

            // Text to ArrayList
            while ((line = buffer.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "`\"{}[].;,!()?:\t\r\n “”_-–—0123456789/#$%&*|\\@");
                while (tokenizer.hasMoreTokens()) {
                    String next = tokenizer.nextToken().toLowerCase();
                    next = next.replaceAll("(['‘’])", "");
                    if (!stopWords.contains(next)) {
                        temp.add(next);
                    }
                }
            }

            // Chunk and add to context
            for (int idx = 0; idx < temp.size(); idx++) {
                // Print a progress bar so we know the code is running
                System.out.print(ProgressBar.get((idx/(double)temp.size()) * 100));
                String key = temp.get(idx);
                context.add(key, getChunkFrom(temp, idx - k, idx));
                context.add(key, getChunkFrom(temp, idx + 1, idx + k + 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Saving to file...                                        \n");
        try {
            this.save(outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Done!                                        \n");
    }

    private void save(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write("input: " + inputPath + "\n");
        buffer.write("output: " + outputPath + "\n");
        buffer.write("k: " + k + "\n\n");

        int counter = 0;
        for (String key: context.getKeys()) {
            System.out.print(ProgressBar.get(counter++/(double)context.size() * 100));
            buffer.write(key + ": " + context.get(key).toString() + "\n");
        }
        buffer.close();
        writer.close();
    }

    public static Word2Vec load(String filename) {
        File name = new File(filename);
        FileReader reader;
        try {
            reader = new FileReader(name.getAbsolutePath());
            Scanner scanner = new Scanner(reader);

            // Load configurations
            String[] configs = { scanner.nextLine(), scanner.nextLine(), scanner.nextLine() };
            String input = "", output = "";
            int k = 0;
            for (String config: configs) {
                Scanner splitter = new Scanner(config);
                splitter.useDelimiter(": ");
                String temp;
                while (splitter.hasNext()) {
                    temp = splitter.next();
                    if (temp.equals("input")) {
                        input = splitter.next();
                    }
                    if (temp.equals("output")) {
                        output = splitter.next();
                    }
                    if (temp.equals("k")) {
                        k = Integer.parseInt(splitter.next());
                    }
                }
            }

            // Load Context
            Context context = new Context();
            scanner.nextLine();
            ArrayList<String> rawContext = new ArrayList<>();
            while (scanner.hasNextLine()) {
                rawContext.add(scanner.nextLine());
            }
            for (int idx = 0; idx < rawContext.size(); ) {
                System.out.print(ProgressBar.get((idx/(double) rawContext.size())*100));
                String[] line = rawContext.get(idx++).split(": ");
                String contextKey = line[0];
                String contextContent = line[1];
                String[] splitContext = contextContent.split("; ");
                MultiSet set = new MultiSet();
                for (String next: splitContext) {
                    String[] splitItem = next.split(",");
                    if (splitItem.length == 2) {
                        set.put(splitItem[0], Integer.parseInt(splitItem[1]));
                    }
                }
                context.put(contextKey, set);
            }
            return new Word2Vec(input, output, k, context);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public MultiSet get(String key) {
        return context.get(key);
    }

    private List<String> getChunkFrom(ArrayList<String> temp, int i, int j) {
        int min = i, max = j;
        if (min < 0) min = 0;
        else if (min > temp.size()) min = temp.size();
        if (max < 0) max = 0;
        else if (max > temp.size()) max = temp.size();
        return temp.subList(min, max);
    }

    public float getSim(String first, String second) {
        return context.get(first).sim(context.get(second));
    }


    @Override
    public String toString() {
        return "{\"inputPath\": " + inputPath
                    + ", \"outputPath\":" + outputPath
                    + ", \"k\"" + k + "}";
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Word2Vec: usage java Word2Vec <init_file_path>");
            return;
        }
        String initPath = args[0];
        Word2Vec wvec = new Word2Vec(initPath);
        List<SetElement> top = wvec.get("Venice").top(3);
        System.out.print("\n");
        for (SetElement element: top) {
            System.out.print(element);
        }
    }
}
