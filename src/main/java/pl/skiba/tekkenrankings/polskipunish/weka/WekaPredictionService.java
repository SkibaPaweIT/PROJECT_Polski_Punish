package pl.skiba.tekkenrankings.polskipunish.weka;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class WekaPredictionService {

    public static void main(String[] args) throws Exception {
        ConverterUtils.DataSource source = new ConverterUtils.DataSource("D:\\Projects\\Java\\DFTrain2.arff");
        Instances trainDataset = source.getDataSet();
        trainDataset.setClassIndex(trainDataset.numAttributes()-1);
        int numClasses = trainDataset.numClasses();
        for(int i = 0; i< numClasses; i++){
            String classValue = trainDataset.classAttribute().value(i);
            System.out.println("Class Value " + i + " is " + classValue);
        }

        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(trainDataset);

        ConverterUtils.DataSource source1 = new ConverterUtils.DataSource("D:\\Projects\\Java\\DFTest2.arff");
        Instances testDataset = source1.getDataSet();
        testDataset.setClassIndex(testDataset.numAttributes()-1);
        System.out.println("========================");
        System.out.println("Actual Class, NB Predicted");
        for(int i =0; i< testDataset.numInstances(); i++){
            double actualClass = testDataset.instance(i).classValue();
            String actual = testDataset.classAttribute().value((int) actualClass);
            Instance newInst = testDataset.instance(i);
            double predNB = nb.classifyInstance(newInst);
            String predString = testDataset.classAttribute().value((int) predNB);
            System.out.println(actual+", "+predString);
        }
    }
}
