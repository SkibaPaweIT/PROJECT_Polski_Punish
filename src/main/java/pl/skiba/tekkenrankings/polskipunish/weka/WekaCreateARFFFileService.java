package pl.skiba.tekkenrankings.polskipunish.weka;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import java.io.File;
import java.io.IOException;

public class WekaCreateARFFFileService {
    public static void main(String[] args) throws IOException {
        //Getting csv file
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File("D:\\Projects\\Java\\DataFrameTekken.csv"));
        Instances data = loader.getDataSet();
        ArffSaver saver = new ArffSaver();

        //Creating ARFF file from csv file
        saver.setInstances(data);
        saver.setFile(new File("D:\\Projects\\Java\\DataFrameTekken.arff"));
        saver.writeBatch();
    }
}
