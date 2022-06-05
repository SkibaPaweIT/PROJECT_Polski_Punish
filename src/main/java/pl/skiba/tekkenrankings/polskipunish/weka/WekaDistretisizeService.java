package pl.skiba.tekkenrankings.polskipunish.weka;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;
import weka.filters.unsupervised.attribute.Remove;

import java.io.File;

public class WekaDistretisizeService {
    public static void main(String[] args) throws Exception {
        //Getting csv file
        ConverterUtils.DataSource source = new ConverterUtils.DataSource("D:\\Projects\\Java\\DataFrameTekkenFiltered.arff");
        Instances data = source.getDataSet();

        Discretize discretize = new Discretize();
        discretize.setInputFormat(data);
        Instances newData = Filter.useFilter(data, discretize);

        ArffSaver saver = new ArffSaver();
        //Saving filtered values
        saver.setInstances(newData);
        saver.setFile(new File("D:\\Projects\\Java\\DataFrameTekkenFiltered.arff"));
        saver.writeBatch();
    }
}
