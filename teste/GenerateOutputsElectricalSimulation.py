import pandas as pd

import xlsxwriter
import scipy
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt

class identifySETSusceptibility:
    def __init__(self, pathfilename, faultSignals, outputSignals, siganalList):
        self.pathfilename = pathfilename
        self.faultSognals = faultSignals
        self.outputSignals = outputSignals
        self.signalsComb = siganalList
        self.signalList = signalsList
        self.file = pd.read_csv(self.pathfilename, header=None, delim_whitespace=True, names=self.signalList)

    def getfile(self):
        return self.file

    def getSpecs(self, header):
        #self.file[header].head()
        print(str(self.file[header].head()))

    def plotLineFigure(self, axisNameX, axisNameY, columnX, columnY):

        sns.set_theme(style="darkgrid")
        sns.lineplot(x=columnX, y=columnY,
                     data=self.file)
        plt.xlabel(axisNameX)
        plt.ylabel(axisNameY)
        plt.show()

def parseOutputSimulation(filename, signalList):  # AQUI

    print("filename: " + filename)
    l = ["G76gat", "G7gat"]
    c17 = identifySETSusceptibility(pathfilename=filename, faultSignals=["w3"], outputSignals= l, siganalList= signalList)
    c17.getSpecs('w3')

    c17.plotLineFigure("Time n(s)", "Voltage (V)", "time", "w3")
    c17.plotLineFigure("Time n(s)", "Voltage (V)", "time", "G6gat")
    c17.plotLineFigure("Time n(s)", "Voltage (V)", "time", "G7gat")


    #file = pd.read_csv(filename, header=None, delim_whitespace=True, names=signalList)

    #print(file)

    # print(file['w3'].head())

    #plt.style.use('_mpl-gallery')

    # make data
    '''
    x = file['time'] #np.linspace(0, 10, 100)
    y = file['w3'] #4 + 2 * np.sin(2 * x)


    sns.set_theme(style="darkgrid")

    sns.lineplot(x="time", y="w3",
                 data=file)
    plt.xlabel('Time')
    plt.ylabel('Voltage(V)')
    plt.show()
    '''




signalsList = ["time", "w3","time2", "G6gat","time3", "G7gat"]
parseOutputSimulation("./teste/c1700000__w3_Outputs_G6gat_G7gat.txt", signalsList)


print("Hello World")



