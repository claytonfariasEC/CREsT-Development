import pandas as pd
import xlsxwriter
import scipy
import numpy as np

import matplotlib.pyplot as plt
def returnList(list, i, column):
    t = []
    for index in range(len(list)):
        t.append(list[i][column])

    return t

def combineData(timeSeries, signalsValues, signalsList):
    data = {'tempo': timeSeries, "X": signalsValues}

    '''
    for i in range(len(timeSeries)):
        for sigPos in range(len(signalsValues)):
            if timeSeries[i] in data:
                temp = data[timeSeries[i]]
                data[timeSeries[i]] = {str(signalsList[sigPos]): signalsValues[sigPos]}
            else:
                data[timeSeries[i]] = {signalsList[sigPos]: signalsValues[sigPos]}

    '''
    print("-------------")
    listFinal = []
    j = 0

    pos = 0
    sigPos = 0
    while(sigPos<len(signalsList)):
        for i in range(len(signalsValues)):
            l = []
            #for v in range (len(signalsValues[sigPos])):
            x = signalsValues[i][sigPos]
            l.append(x)
            #pos=+1
            print(l)
            listFinal.append(l)
        sigPos= sigPos +1

    print("---V@----------")
    print(listFinal)
    #    print(signalsValues[i])
        #sigT = []
        #for sigV in range(len(signalsValues[i])):

        #    x = returnList(signalsValues, sigV)
        #    sigT.append(x)
        #    print(str(i) + "_" + str(sigV) + " = " + str(x))
        #listFinal.append(sigT)

    print("DATA: ")
    print(data)
    strColumns = [ele for ele in signalsList]
    print(strColumns)
    df = pd.DataFrame(data, columns=[strColumns])
    print(df)

    #print(listFinal)
    return ""



def getTimeSeriesOutput(contentFile, signalsList):

    #print("Content line: " + str(contentFile))
    time = []
    signalsValues = []
    for i in range(len(contentFile)):
        #if(i < 10):
            #print(contentFile[i])
        try:
            x = contentFile[i].replace(" ", ",")
            contentClean = x.split(",")
            res = [ele for ele in contentClean if ele.strip()]
            #print( str(i) + " Time x posX: " + str(res))
            time.append(res[0])

            signals = []
            for pos in range(0, len(res), 2):
                signals.append(res[pos+1])

            signalsValues.append(signals)
            #if(i<10):
                #print(str(i) + " time: " + str(res[i]) + " value: " + str(res[i + 1]))

        except:
            print("OPS")

    #print("sigs: " + str(signalsValues))

    #combineData(time, signalsValues, signalsList)
    return time

def parseOutputSimulation(filename, signalList):  # AQUI

    #file = open (filename, 'r')
    #contentFile = file.readlines()

    print("filename: " + filename)

    #print(contentFile)

    #time = getTimeSeriesOutput(contentFile, signalList)

    file = pd.read_csv(filename, header=None, delim_whitespace=True, names=signalList)

    print(file)

    print(file['w3'].head())

    file['w3'].plot(kind='kde', figsize=(14, 6))

    fig, ax = plt.subplots()
    ax = sns.regplot(x='minutos', y='Lag_1', data=agenda, ci=None, scatter_kws=dict(color='0.35'))
    ax.set_aspect('equal')
    ax.set_title('Lag Plot of Hardcover Sales');

    #writer = pd.ExcelWriter(str("nome_saida") + '.xlsx', engine='xlsxwriter')

    # Convert the dataframe to an XlsxWriter Excel object.
    #pd.to_excel(writer, sheet_name="nome_inversor")

    # Close the Pandas Excel writer and output the Excel file.
    #writer.save()
    #print("Time: " + str(time))

    #file.close()

    # print("Arquivos temporarios excluidos")
    # sos.remove("saida_parcial_inv_"+str(numero_aleatorio)+".txt")

signalsList = ["time", "w3","time2", "G6gat","time3", "G7gat"]
parseOutputSimulation("./teste/c1700000__w3_Outputs_G6gat_G7gat.txt", signalsList)


print("Hello World")



