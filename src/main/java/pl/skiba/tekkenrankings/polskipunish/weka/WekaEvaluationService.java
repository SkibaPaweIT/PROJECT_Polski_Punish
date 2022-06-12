package pl.skiba.tekkenrankings.polskipunish.weka;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class WekaEvaluationService {

    public static void main(String[] args) throws Exception {
        ConverterUtils.DataSource source = new ConverterUtils.DataSource("D:\\Projects\\Java\\DFTrain2.arff");
        Instances trainDataset = source.getDataSet();
        trainDataset.setClassIndex(trainDataset.numAttributes() - 1);

        J48 tree = new J48();
        tree.buildClassifier(trainDataset);
        Evaluation eval = new Evaluation(trainDataset);

        ConverterUtils.DataSource source1 = new ConverterUtils.DataSource("D:\\Projects\\Java\\DFTest2.arff");
        Instances testDataset = source1.getDataSet();
        testDataset.setClassIndex(testDataset.numAttributes()-1);
        eval.evaluateModel(tree, testDataset);
        System.out.println(eval.toSummaryString("Evaluation results:\n", false));
        System.out.println("Correct % = "+eval.pctCorrect());
        System.out.println("Incorrect % = "+eval.pctIncorrect());
        System.out.println("AUC % = "+eval.areaUnderROC(1));
        System.out.println("kappa % = "+eval.kappa());
        System.out.println("ERROR Rate = " + eval.errorRate());
    }
}
