import random
import os
import time

import pandas as pd



import matplotlib.pyplot as plt

def Encontra_String (copia,substring):

    linha = 0

    linha_encontrada = 0

    for i in copia:
        linha = linha + 1
        if substring in i:
            matching = i
            linha_encontrada = linha

    print("Substring encontrado :" + str(matching))


    return (linha_encontrada)

def Print(Lista):

    tam = len(Lista)

    for i in range(tam):
        print(str(i) +"-" +Lista[i])

def Executa_ng_spice_main(nome_arquivo): #ok

    os.system("ngspice " + nome_arquivo)

def limpa_string_espacos(pos_min,pos_max,copia):

    i = pos_min

    temp = copia

    print("111111111111111111111111111111111111111111111111111111111111111111111\n")

    pos_max = 1


    troca_por_virgula = temp.replace (".", ",", 1)
    #troca = troca_por_virgula.replace (" ", "", 1)

    tranformar para o pandas

    print("0000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111\n\ns")
    print(troca_por_virgula)

    return(copia)

def cria_vetor_tempo(copia):

    tam = len(copia)

    tempo = []
    tam = len(copia)
    #print (tam)

    for i in range (tam):
        pos = copia[i].index (',')
        aux = "="+copia[i]
        aux = aux[0:pos]
        #print ("------", aux)
        #print (pos)
        tempo.append (aux)

    return(tempo)

def cria_vetor_posicao(str):

    tam = len(str)

    posicao = []
    tam = len (str)
    #print (tam)

    for i in range (tam):
        pos = str[i].index (',')
        aux = str[i]
        aux = "="+aux[pos+1:-1]
        #print ("------", aux)
        #print (pos)
        posicao.append (aux)

    return(posicao)

def salva_em_excel(tempo,tensao,nome_inversor,nome_saida):

    data = {'tempo': tempo, 'tensao': tensao}

    df = pd.DataFrame (data, columns = ['tempo', 'tensao'])

    #print("....")
    #print(df)

    writer = pd.ExcelWriter (str(nome_saida)+'.xlsx', engine = 'xlsxwriter')

    # Convert the dataframe to an XlsxWriter Excel object.
    df.to_excel (writer, sheet_name = nome_inversor)

    # Close the Pandas Excel writer and output the Excel file.
    writer.save ()

    print("Arquivo salvo com sucesso nome: "+str(nome_saida)+".xlsx")

def parseOutputSimulation(filename):    #AQUI

            arquivo_temp = open (filename, 'r')
            file = arquivo_temp.read()
            #arquivo_temp2 = open ("saida_parcial_st_" + str (numero_aleatorio) + ".txt", 'w')

            print("filename: " + filename)
            print(file)

            copia = []

            #copia2 = []

            copia = arquivo_temp.readlines()
            #copia2 = arquivo_temp.readlines()

            copia_inv = limpa_string_espacos(0,10,file) #inversor tradicional inv

            #copia_st = limpa_string_espacos(pos_min ,pos_max,copia2) #inversor_st

            #arquivo_temp.writelines(copia_inv)
            #arquivo_temp2.writelines(copia_st)

            #print(copia_inv)

            arquivo_temp.close()
            #arquivo_temp2.close()

            #arquivo_resultado.close()
            #arquivo_resultado2.close()


            #print("Arquivos temporarios excluidos")
            #sos.remove("saida_parcial_inv_"+str(numero_aleatorio)+".txt")






#injeta_OUT_GND()
#print(input)
print("olá mundo")

parseOutputSimulation("./teste/c1700000__w3_Outputs_G6gat_G7gat.txt")