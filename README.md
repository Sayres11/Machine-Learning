# Machine-Learning
University machine learning projects
#K-nn
The goal is to write a program that takes the following arguments:

k: a positive integer representing the hyperparameter for k-NN.

train-set: the name of the file containing the training set in CSV format, with the last column representing the target attribute.

test-set: the name of the file containing the test set in CSV format, with the last column representing the target attribute.

Requirements:
The program should perform k-NN classification on all observations from the test-set file based on the train-set file and provide the accuracy of this classification (the proportion of correctly classified test examples).

The program should also provide a testing interface (not necessarily graphical) that allows the user to enter individual vectors for classification and displays their k-NN labels based on the train-set.

Test it on data from the training and test sets located in the iris.data and iris.test.data files.

Note: The program should accept any dataset (in a format similar to iris.data) and adapt to any number of dimensions.

#Perceptron
The file perceptron.data contains the training data: a subset of the Iris dataset limited to Iris-versicolor and Iris-virginica. The file perceptron.test.data contains the test set. Implement a perceptron and train it to distinguish between the two species. Test it on the test set and print the classification accuracy.

The program should allow:

Loading any training set from a CSV file, where the last column is the target attribute. The number of weights should adapt to the loaded dataset. (!!)
Choosing a learning rate.
A simple interface that allows manual input of vectors for classification.
