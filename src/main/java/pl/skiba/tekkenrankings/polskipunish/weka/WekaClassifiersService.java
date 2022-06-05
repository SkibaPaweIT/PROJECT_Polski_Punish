package pl.skiba.tekkenrankings.polskipunish.weka;


import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.io.IOException;

public class WekaClassifiersService {
    public static void main(String[] args) throws Exception {
        ConverterUtils.DataSource source = new ConverterUtils.DataSource("D:\\Projects\\Java\\DataFrameTekkenFiltered.arff");
        Instances dataset = source.getDataSet();
        dataset.setClassIndex(dataset.numAttributes()-1);

        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(dataset);
        System.out.println(nb.getCapabilities().toString());

        SMO svm = new SMO();
        svm.buildClassifier(dataset);
        System.out.println(svm.getCapabilities().toString());

        String[] options = new String[4];
        options[0] = "-C"; options[1] = "0.11";
        options[2] = "-M"; options[3] = "3";
        J48 tree = new J48();
        tree.setOptions(options);
        tree.buildClassifier(dataset);
        System.out.println(tree.getCapabilities().toString());
        System.out.println(tree.graph());
    }
}
