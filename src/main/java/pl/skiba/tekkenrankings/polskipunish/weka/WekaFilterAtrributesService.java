package pl.skiba.tekkenrankings.polskipunish.weka;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;
import weka.filters.unsupervised.attribute.Remove;

import java.io.File;

public class WekaFilterAtrributesService {
    public static void main(String[] args) throws Exception {
        //Getting csv file
        ConverterUtils.DataSource source = new ConverterUtils.DataSource("D:\\Projects\\Java\\DataFrameTekken.arff");
        Instances data = source.getDataSet();

        String[] opts = new String[]{"-R", "2,5,11,14"};
        Remove remove = new Remove();
        remove.setOptions(opts);

        remove.setInputFormat(data);
        Instances newData = Filter.useFilter(data, remove);

        ArffSaver saver = new ArffSaver();
        //Saving filtered values
        saver.setInstances(newData);
        saver.setFile(new File("D:\\Projects\\Java\\DataFrameTekkenFiltered.arff"));
        saver.writeBatch();
    }
}
