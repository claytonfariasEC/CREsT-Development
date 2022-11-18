
timeSeries = ["0.001", "0.001", "0.002"]
signalsList = ["w3", "G6gat", "G7gat"]
data = {'tempo': timeSeries}
signalsValues = [ [1,2,3 ], [5,6,7] , [8,9,10]]


# FaultSig: 1, G6gat: 2, G7gat: 3}
for i in range(len(timeSeries)):

        if timeSeries[i] in data:
            for sigPos in range(len(signalsValues)):  # TODOS OS SINAIS
                temp = data[timeSeries[i]]
                data[timeSeries[i]].update()
                #Dictionary1.update(B='For', C='Geeks')
                print(temp)

        else:
            data[timeSeries[i]] = {signalsList[sigPos]: signalsValues[sigPos]}

print(data)