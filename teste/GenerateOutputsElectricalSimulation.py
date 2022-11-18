def returnList(list, pos):
    t = []
    for i in range(len(list)):
        t.append(list[i][pos])

    return t

def combineData(timeSeries, signalsValues, signalsList):
    data = {'tempo': timeSeries}

    '''
    for i in range(len(timeSeries)):
        for sigPos in range(len(signalsValues)):
            if timeSeries[i] in data:
                temp = data[timeSeries[i]]
                data[timeSeries[i]] = {str(signalsList[sigPos]): signalsValues[sigPos]}
            else:
                data[timeSeries[i]] = {signalsList[sigPos]: signalsValues[sigPos]}

    '''
    for i in range(len(signalsValues)):
        #print(signalsValues[i])
        sigT = []
        for j in range(len(signalsList)):
            x = returnList(signalsValues, j)
            sigT.append(x)
            print(str(i) + "_" + str(j) + " = " + str(x))

    print("DATA: ")
    print(data)
    return ""



def getTimeSeriesOutput(contentFile, signalsList):

    #print("Content line: " + str(contentFile))
    time = []
    signalsValues = []
    for i in range (len(contentFile)):
        if(i < 2):
            #print(contentFile[i])
            x = contentFile[i].replace(" ", ",")
            contentClean = x.split(",")
            res = [ele for ele in contentClean if ele.strip()]
            print( str(i) + " Time x posX: " + str(res))
            time.append(res[0])

            signals = []
            for pos in range(0, len(res), 2):
                signals.append(res[pos+1])

            signalsValues.append(signals)
            #    print(str(i) + " time: " + str(res[i]) + " value: " + str(res[i + 1]))


    print("sigs: " + str(signalsValues))

    combineData(time, signalsValues, signalsList)
    return time

def parseOutputSimulation(filename, signalList):  # AQUI

    file = open (filename, 'r')
    contentFile = file.readlines()

    print("filename: " + filename)

    #print(contentFile)

    time = getTimeSeriesOutput(contentFile, signalList)

    print("Time: " + str(time))

    file.close()

    # print("Arquivos temporarios excluidos")
    # sos.remove("saida_parcial_inv_"+str(numero_aleatorio)+".txt")

signalsList = ["w3", "G6gat", "G7gat"]
parseOutputSimulation("./teste/c1700000__w3_Outputs_G6gat_G7gat.txt", signalsList)


print("Hello World")



