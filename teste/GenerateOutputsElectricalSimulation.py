import pandas as pd

import xlsxwriter
import scipy
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt

class identifySETSusceptibility:
    def __init__(self, pathdataname, faultSignals, outputSignals, siganalList):
        self.pathdataname = pathdataname
        self.faultSognals = faultSignals
        self.outputSignals = outputSignals
        self.signalsComb = siganalList
        self.signalList = signalsList

        try:
            self.data = pd.read_csv(self.pathdataname, header=None, delim_whitespace=True, names=self.signalList)
        except:
            print("NOT INCLUDED INPUT FILE:  " + pathdataname)
    def getdata(self):
        return self.data

    def getSpecs(self, header):
        #self.data[header].head()
        print(str(self.data[header].head()))
    def getInfo(self):
        print("---------------------------------------")
        print(str(self.data.head()))
        print(str(self.data.describe()))
        print("---------------------------------------")

    def delcolumns(self, namelist):

        for i in range(len(namelist)):
            #df = pd.DataFrame({"a": [1, 2, 3], "b": [2, 4, 6]})
            print("The DataFrame object before deleting the column")
            #print(df)
            del self.data[namelist[i]]
            print("The DataFrame object after deleting the column --> " + str(namelist[i]))
            #print(self.data)

    def plotLineFigure(self, axisNameX, axisNameY, columnX, columnY):

        sns.set_theme(style="darkgrid")
        sns.lineplot(x=columnX, y=columnY,
                     data=self.data).set(title=columnY)
        plt.xlabel(axisNameX)
        plt.ylabel(axisNameY)
        plt.show()

    def plotLineFigureData(self, DATA, axisNameX, axisNameY, columnX, columnY):

        sns.set_theme(style="darkgrid")
        sns.lineplot(x=columnX, y=columnY,
                     data=DATA).set(title=columnY)
        plt.xlabel(axisNameX)
        plt.ylabel(axisNameY)
        plt.show()
    def plotMultipleLineFigure(self, axisNameX, axisNameY, columnsList):

        sns.set_theme(style="darkgrid")

        data = pd.DataFrame(self.data)
        fig, ax = plt.subplots()
        cont = 0
        subStr = ""
        for i in columnsList:
            if(cont == 0):
                #subStr =
                cont= cont + 1
            ax = sns.lineplot(x='time', y=i, data=data,  label=  subStr + "Signal " + str(i))
            subStr = ""
        #my_dict = dict(x=x, h=h)
        h = 0.5
        ax = sns.lineplot(x='time', y=h, data=data,  label= "Threshold")
        #ax1 = sns.lineplot(x='time', y='G6gat', data=data)
        #print("X0: " + str(len(self.data)))

        plt.xlabel(axisNameX)
        plt.ylabel(axisNameY)
        plt.legend(loc='upper right')
        plt.title("All signals")
        plt.show()

    def plotLineFigureThreshold(self, axisNameX, axisNameY, columnsList):
        '''
        sns.set_theme(style="darkgrid")
        sns.lineplot(x=columnX, y=columnY,
                     data=self.data).set(title=columnY)
        plt.xlabel(axisNameX)
        plt.ylabel(axisNameY)
        plt.show()
        '''

        #n = 100

        #y1 = self.data['w3'] #np.sin(2 * np.pi * x)
        #y2 = self.data['G6gat']
        #y3 = self.data['G7gat']
        sns.set_theme(style="darkgrid")

        data = pd.DataFrame(self.data)
        fig, ax = plt.subplots()
        cont = 0
        subStr = ""
        for i in columnsList:
            if(cont == 0):
                subStr ="Fault "
                cont= cont + 1
            ax = sns.lineplot(x='time', y=i, data=data,  label=  subStr + "Signal " + str(i))
            subStr = ""
        #my_dict = dict(x=x, h=h)
        h = 0.5
        ax = sns.lineplot(x='time', y=h, data=data,  label= "Threshold")
        #ax1 = sns.lineplot(x='time', y='G6gat', data=data)
        #print("X0: " + str(len(self.data)))

        plt.xlabel(axisNameX)
        plt.ylabel(axisNameY)
        plt.legend(loc='upper right')
        plt.title("All signals")
        plt.show()

class dataSetInformation:
    def __init__(self, data, nominalVoltage):
        self.data = data
        self.max = 0
        self.min = -100
        self.nominalVoltage = nominalVoltage

    def extractInformation(self, column):
        max = self.data[column].max()
        min = self.data[column].min()

        print("Column Name: " + column)
        print("Max: " + str(max))
        print("Min: " + str(min))
        print("Theshold voltage to consider bitflip: " + str(self.nominalVoltage/2) + " (V)")

    def analysisSETFault (self, outputSignal):
        list = []

        thresholdVoltage = self.nominalVoltage/2

        interval = self.data[self.data[outputSignal] > thresholdVoltage]
        initTime = interval[0:1]
        finalTime = interval[len(interval)-1:len(interval)]



        #for i in self.data[faultSignal]:
        #    if(self.data[faultSignal][i] >= thresholdVoltage):
        #        print(str(self.data[faultSignal][i]))
        #        #list.append(self.data[faultSignal][i])

        print("--------- Identified interval ----------")
        print(interval)
        print("Shape: " + str(interval.shape))
        print(str(interval.describe()))
        print("Init: " + str(initTime))
        print("Final: " + str(finalTime))

        fig = identifySETSusceptibility(pathdataname="", faultSignals=["w3"], outputSignals= ["G6gat", "G7gat"], siganalList=["G6gat","time3", "G7gat"] )
        fig.plotLineFigureData(interval, "Time n(s)", "Voltage (V)", "time", "G6gat")
        #def singleEventTransientanalysisThreshold(self):



def parseOutputSimulation(dataname, signalList):  # AQUI

    print("dataname: " + dataname)


    nominalVoltage = 1.0
    l = ["G76gat", "G7gat"]
    c17 = identifySETSusceptibility(pathdataname=dataname, faultSignals=["w3"], outputSignals= l, siganalList= signalList)
    c17.getSpecs('w3')
    c17.delcolumns(["time2", "time3"])
    c17.getInfo()

    #c17.plotLineFigure("Time n(s)", "Voltage (V)", "time", "w3")
    #c17.plotLineFigure("Time n(s)", "Voltage (V)", "time", "G6gat")
    #c17.plotLineFigure("Time n(s)", "Voltage (V)", "time", "G7gat")

    c17.plotMultipleLineFigure("Time n(s)", "Voltage (V)", ["G6gat", "G7gat"])
    c17.plotLineFigureThreshold("Time n(s)", "Voltage (V)", ["w3", "G6gat", "G7gat"])



    analysis = dataSetInformation(c17.getdata(), nominalVoltage)
    analysis.extractInformation("w3")
    analysis.analysisSETFault("G6gat")





signalsList = ["time", "w3","time2", "G6gat","time3", "G7gat"]
parseOutputSimulation("./teste/c1700000__w3_Outputs_G6gat_G7gat.txt", signalsList)


