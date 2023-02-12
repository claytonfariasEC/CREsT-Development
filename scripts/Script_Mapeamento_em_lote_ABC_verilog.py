import glob
from operator import ge
import os


#def readFolder():
#    pritn("EEEE")


def circuit_lib_type_switcher(arg):
    switcher = {"blif": blif_format,
                "bench": bench_format,
                "genlib": genlib_format}
    return switcher.get(arg, lambda: "Invalid arg")()


def blif_format():
    return "read_blif"


def bench_format():
    return "read_bench"


def genlib_format():
    return "read_genlib"


def get_circuit_name(filename):
    return filename.split(".")[0]


def get_lib_name(lib_name):
    return lib_name.split(".")[0]


def mapCircuit(nomeCircuit, genlib, bench_cmd, lib_cmd, output_path, pathx):
    nameCircuit = get_circuit_name(nomeCircuit)
    nameGenlib = get_lib_name(genlib)#"cadence.genlib"  #get_lib_name(genlib)
    print("-    Circuito: " + nomeCircuit  + "   -> " + nameCircuit + " -> " + nameGenlib +  " -  outPath " +  output_path + "\n")
    print("-        Genlib: " + genlib)
    
    c = nameCircuit.split("/")
    circ = c[1]
    #print(c)
    #cx = c[1].split(".")
    
    
    g = genlib.split("/")
    #print(g)
    gen = g[1].split(".")
    x = gen[0]
    #print(x) 

    #os.system("./abc -c 'read_blif " + str(nomeCircuit)+ "'" + " -c 'read_genlib " + genlib + "'" + " '-c map'" + "'-c write_verilog " + nameCircuit + "_" + nameGenlib  + ".v'")

    first_step_cmd = "%s %s;" % (lib_cmd, str(genlib))
    second_step_cmd = "%s %s;" % (bench_cmd, str(nomeCircuit))
    third_step_cmd = "map;"
    #fourth_step_cmd = "write_verilog %s/%s_%s.v" % ("", nameCircuit, nameGenlib)

    fourth_step_cmd = "write_verilog " + g[0] + "/" + x + "/" + circ + "_" + x + ".v"
    
    #%s/%s_%s.v" % ("", nameCircuit, x)

    #print("----> " + first_step_cmd, second_step_cmd, third_step_cmd, "   fourth: " + fourth_step_cmd)

    abc_full_cmd = "./abc -c \'%s %s %s %s\'" % (first_step_cmd, second_step_cmd, third_step_cmd, fourth_step_cmd)
    
    print(abc_full_cmd)
    os.system(abc_full_cmd)


# Script configuration file extensions
bench = "v"
library = "genlib"
#######################

#
circuitList = []
libList = []
bench_type = "read_verilog" #circuit_lib_type_switcher(bench)
lib_type = circuit_lib_type_switcher(library)

print("-----------")
pathx = "circuitos/"
for file in glob.glob(pathx+"*.%s" % bench):
    circuitList.append(file)
    print(file)

for genlib in glob.glob(pathx+"*.%s" % library):
    libList.append(genlib)
    print(genlib)

#print("files: " + str(circuitLists)))


for lib in libList:
    output_path = get_lib_name(lib) #+ "/"
    print(" falg: " + output_path)
    if not os.path.exists(output_path):
        #os.makedirs(output_path)
        os.system("sudo mkdir " + output_path)

    
    for i in circuitList:
        #mapCircuit(i, lib, bench_type, "read_verilog -m", output_path,pathx)
        lib_cmd = "read_genlib"
        bench_cmd = "read_verilog -m"
        first_step_cmd = "%s %s; %s;" % (bench_cmd, str(i), "print_gates")
        second_step_cmd = "%s %s;" % (lib_cmd, str(genlib))
        third_step_cmd = "map; print_gates;"
        g = genlib.split("/")
        print(g)
        gen = g[1].split(".")
        x = gen[0]
        print(x) 
        c = i.split("/")
        circ = c[1]
        circName = circ.split(".")
        print("--> circuito: " + circ)
        fourth_step_cmd = "write_verilog " + g[0] + "/" + x + "/" + circName[0] + "_" + x + ".v"
        abc_full_cmd = "sudo ./abc -c \'%s %s %s %s %s\'" % ("read_genlib cadence_original.genlib;",first_step_cmd, second_step_cmd, third_step_cmd, fourth_step_cmd)
        print("- Command line: " + abc_full_cmd)
        os.system(abc_full_cmd)
    print("-----------")