package pl.skiba.tekkenrankings.polskipunish.weka;

import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class WekaLinearRegressionService {
    public static void main(String[] args) throws Exception {
        ConverterUtils.DataSource source = new ConverterUtils.DataSource("D:\\Projects\\Java\\DataFrameTekkenFiltered.arff");
        Instances dataset = source.getDataSet();
        dataset.setClassIndex(dataset.numAttributes()-1);

        LinearRegression lr = new LinearRegression();
        lr.buildClassifier(dataset);
        System.out.println(lr);
    }
}
