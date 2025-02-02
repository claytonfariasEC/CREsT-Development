//Converted to Combinational , Module name: s838 , Timestamp: 2018-12-03T15:51:02.101871 
module s838 ( X, Clear, C_32, C_31, C_30, C_29, C_28, C_27, C_26, C_25, C_24, C_23, C_22, C_21, C_20, C_19, C_18, C_17, C_16, C_15, C_14, C_13, C_12, C_11, C_10, C_9, C_8, C_7, C_6, C_5, C_4, C_0, Y_4, Y_3, Y_2, Y_1, Y_8, Y_7, Y_6, Y_5, Y_12, Y_11, Y_10, Y_9, Y_16, Y_15, Y_14, Y_13, Y_20, Y_19, Y_18, Y_17, Y_24, Y_23, Y_22, Y_21, Y_28, Y_27, Y_26, Y_25, Y_32, Y_31, Y_30, Y_29, W, Z, n75, n80, n85, n90, n95, n100, n105, n110, n115, n120, n125, n130, n135, n140, n145, n150, n155, n160, n165, n170, n175, n180, n185, n190, n195, n200, n205, n210, n215, n220, n225, n230 );
input C_1, C_2, C_3, X, Clear, C_32, C_31, C_30, C_29, C_28, C_27, C_26, C_25, C_24, C_23, C_22, C_21, C_20, C_19, C_18, C_17, C_16, C_15, C_14, C_13, C_12, C_11, C_10, C_9, C_8, C_7, C_6, C_5, C_4, C_0, Y_4, Y_3, Y_2, Y_1, Y_8, Y_7, Y_6, Y_5, Y_12, Y_11, Y_10, Y_9, Y_16, Y_15, Y_14, Y_13, Y_20, Y_19, Y_18, Y_17, Y_24, Y_23, Y_22, Y_21, Y_28, Y_27, Y_26, Y_25, Y_32, Y_31, Y_30, Y_29;
output W, Z, n75, n80, n85, n90, n95, n100, n105, n110, n115, n120, n125, n130, n135, n140, n145, n150, n155, n160, n165, n170, n175, n180, n185, n190, n195, n200, n205, n210, n215, n220, n225, n230;
wire n133, n134, n136, n137, n138, n139, n140_1, n141, n142, n143, n144, n145_1, n146, n147, n148, n149, n150_1, n151, n152, n153, n154, n155_1, n156, n157, n158, n159, n160_1, n161, n162, n163, n164, n165_1, n166, n167, n168, n169, n170_1, n171, n172, n173, n174, n175_1, n176, n177, n178, n179, n180_1, n181, n182, n183, n184, n185_1, n186, n187, n188, n189, n190_1, n191, n192, n193, n194, n195_1, n196, n197, n198, n199, n200_1, n201, n202, n203, n204, n205_1, n206, n207, n208, n209, n210_1, n211, n212, n213, n214, n215_1, n216, n217, n218, n219, n220_1, n221, n222, n223, n224, n225_1, n226, n228, n229, n230_1, n231, n232, n234, n235, n237, n238, n241, n242, n243, n244, n245, n246, n248, n249, n250, n254, n255, n256, n257, n258, n260, n261, n262, n266, n267, n268, n269, n270, n272, n273, n275, n278, n279, n280, n281, n282, n283, n285, n286, n287, n291, n292, n293, n294, n295, n297, n298, n299, n303, n304, n305, n306, n307, n309, n310, n312, n315, n316, n317, n318, n320, n321, n322;
INVX1    g000(.A(Y_32), .Y(n133));
NAND3X1  g001(.A(Y_29), .B(Y_30), .C(Y_31), .Y(n134));
NOR2X1   g002(.A(n134), .B(n133), .Y(W));
INVX1    g003(.A(Y_28), .Y(n136));
INVX1    g004(.A(Y_29), .Y(n137));
INVX1    g005(.A(Y_24), .Y(n138));
INVX1    g006(.A(Y_23), .Y(n139));
INVX1    g007(.A(Y_22), .Y(n140_1));
INVX1    g008(.A(Y_16), .Y(n141));
INVX1    g009(.A(Y_18), .Y(n142));
INVX1    g010(.A(Y_17), .Y(n143));
INVX1    g011(.A(Y_12), .Y(n144));
INVX1    g012(.A(Y_11), .Y(n145_1));
INVX1    g013(.A(Y_10), .Y(n146));
INVX1    g014(.A(Y_4), .Y(n147));
INVX1    g015(.A(Y_6), .Y(n148));
INVX1    g016(.A(Y_5), .Y(n149));
INVX1    g017(.A(X), .Y(n150_1));
NOR4X1   g018(.A(Y_2), .B(Y_3), .C(n150_1), .D(Y_1), .Y(n151));
NAND4X1  g019(.A(n149), .B(n148), .C(n147), .D(n151), .Y(n152));
NOR4X1   g020(.A(Y_9), .B(Y_7), .C(Y_8), .D(n152), .Y(n153));
NAND4X1  g021(.A(n146), .B(n145_1), .C(n144), .D(n153), .Y(n154));
NOR4X1   g022(.A(Y_13), .B(Y_14), .C(Y_15), .D(n154), .Y(n155_1));
NAND4X1  g023(.A(n143), .B(n142), .C(n141), .D(n155_1), .Y(n156));
NOR4X1   g024(.A(Y_21), .B(Y_19), .C(Y_20), .D(n156), .Y(n157));
NAND4X1  g025(.A(n140_1), .B(n139), .C(n138), .D(n157), .Y(n158));
NOR4X1   g026(.A(Y_25), .B(Y_26), .C(Y_27), .D(n158), .Y(n159));
AND2X1   g027(.A(Y_30), .B(C_30), .Y(n160_1));
NAND4X1  g028(.A(n159), .B(n137), .C(n136), .D(n160_1), .Y(n161));
NAND4X1  g029(.A(Y_29), .B(n136), .C(C_29), .D(n159), .Y(n162));
NAND3X1  g030(.A(n159), .B(Y_28), .C(C_28), .Y(n163));
NAND2X1  g031(.A(Y_27), .B(C_27), .Y(n164));
NOR4X1   g032(.A(n158), .B(Y_25), .C(Y_26), .D(n164), .Y(n165_1));
NAND2X1  g033(.A(Y_26), .B(C_26), .Y(n166));
NOR3X1   g034(.A(n166), .B(n158), .C(Y_25), .Y(n167));
NAND2X1  g035(.A(Y_25), .B(C_25), .Y(n168));
NOR2X1   g036(.A(n168), .B(n158), .Y(n169));
AND2X1   g037(.A(Y_24), .B(C_24), .Y(n170_1));
NAND4X1  g038(.A(n157), .B(n140_1), .C(n139), .D(n170_1), .Y(n171));
NAND4X1  g039(.A(n140_1), .B(Y_23), .C(C_23), .D(n157), .Y(n172));
NAND3X1  g040(.A(n157), .B(Y_22), .C(C_22), .Y(n173));
NAND2X1  g041(.A(Y_21), .B(C_21), .Y(n174));
NOR4X1   g042(.A(n156), .B(Y_19), .C(Y_20), .D(n174), .Y(n175_1));
NAND2X1  g043(.A(Y_20), .B(C_20), .Y(n176));
NOR3X1   g044(.A(n176), .B(n156), .C(Y_19), .Y(n177));
NAND2X1  g045(.A(Y_19), .B(C_19), .Y(n178));
NOR2X1   g046(.A(n178), .B(n156), .Y(n179));
AND2X1   g047(.A(Y_18), .B(C_18), .Y(n180_1));
NAND4X1  g048(.A(n155_1), .B(n143), .C(n141), .D(n180_1), .Y(n181));
NAND4X1  g049(.A(Y_17), .B(n141), .C(C_17), .D(n155_1), .Y(n182));
NAND3X1  g050(.A(n155_1), .B(Y_16), .C(C_16), .Y(n183));
NAND2X1  g051(.A(Y_15), .B(C_15), .Y(n184));
NOR4X1   g052(.A(n154), .B(Y_13), .C(Y_14), .D(n184), .Y(n185_1));
NAND2X1  g053(.A(Y_14), .B(C_14), .Y(n186));
NOR3X1   g054(.A(n186), .B(n154), .C(Y_13), .Y(n187));
NAND2X1  g055(.A(Y_13), .B(C_13), .Y(n188));
NOR2X1   g056(.A(n188), .B(n154), .Y(n189));
AND2X1   g057(.A(Y_12), .B(C_12), .Y(n190_1));
NAND4X1  g058(.A(n153), .B(n146), .C(n145_1), .D(n190_1), .Y(n191));
NAND4X1  g059(.A(n146), .B(Y_11), .C(C_11), .D(n153), .Y(n192));
NAND3X1  g060(.A(n153), .B(Y_10), .C(C_10), .Y(n193));
NAND2X1  g061(.A(Y_9), .B(C_9), .Y(n194));
NOR4X1   g062(.A(n152), .B(Y_7), .C(Y_8), .D(n194), .Y(n195_1));
NAND2X1  g063(.A(Y_8), .B(C_8), .Y(n196));
NOR3X1   g064(.A(n196), .B(n152), .C(Y_7), .Y(n197));
NAND2X1  g065(.A(Y_7), .B(C_7), .Y(n198));
NOR2X1   g066(.A(n198), .B(n152), .Y(n199));
AND2X1   g067(.A(Y_6), .B(C_6), .Y(n200_1));
NAND4X1  g068(.A(n151), .B(n149), .C(n147), .D(n200_1), .Y(n201));
NAND4X1  g069(.A(Y_5), .B(n147), .C(C_5), .D(n151), .Y(n202));
NAND3X1  g070(.A(n151), .B(Y_4), .C(C_4), .Y(n203));
NAND2X1  g071(.A(Y_3), .B(C_3), .Y(n204));
NOR4X1   g072(.A(Y_1), .B(Y_2), .C(n150_1), .D(n204), .Y(n205_1));
NAND2X1  g073(.A(Y_2), .B(C_2), .Y(n206));
NOR3X1   g074(.A(n206), .B(Y_1), .C(n150_1), .Y(n207));
NAND2X1  g075(.A(C_0), .B(X), .Y(n208));
NAND3X1  g076(.A(Y_1), .B(C_1), .C(X), .Y(n209));
NAND2X1  g077(.A(n209), .B(n208), .Y(n210_1));
NOR3X1   g078(.A(n210_1), .B(n207), .C(n205_1), .Y(n211));
NAND4X1  g079(.A(n203), .B(n202), .C(n201), .D(n211), .Y(n212));
NOR4X1   g080(.A(n199), .B(n197), .C(n195_1), .D(n212), .Y(n213));
NAND4X1  g081(.A(n193), .B(n192), .C(n191), .D(n213), .Y(n214));
NOR4X1   g082(.A(n189), .B(n187), .C(n185_1), .D(n214), .Y(n215_1));
NAND4X1  g083(.A(n183), .B(n182), .C(n181), .D(n215_1), .Y(n216));
NOR4X1   g084(.A(n179), .B(n177), .C(n175_1), .D(n216), .Y(n217));
NAND4X1  g085(.A(n173), .B(n172), .C(n171), .D(n217), .Y(n218));
NOR4X1   g086(.A(n169), .B(n167), .C(n165_1), .D(n218), .Y(n219));
AND2X1   g087(.A(n219), .B(n163), .Y(n220_1));
OR4X1    g088(.A(Y_25), .B(Y_26), .C(Y_27), .D(n158), .Y(n221));
NOR4X1   g089(.A(Y_29), .B(Y_30), .C(Y_28), .D(n221), .Y(n222));
NAND2X1  g090(.A(Y_32), .B(C_32), .Y(n223));
NOR2X1   g091(.A(n223), .B(Y_31), .Y(n224));
AND2X1   g092(.A(Y_31), .B(C_31), .Y(n225_1));
OAI21X1  g093(.A0(n225_1), .A1(n224), .B0(n222), .Y(n226));
NAND4X1  g094(.A(n220_1), .B(n162), .C(n161), .D(n226), .Y(Z));
INVX1    g095(.A(Clear), .Y(n228));
NAND4X1  g096(.A(Y_2), .B(n228), .C(X), .D(Y_1), .Y(n229));
NAND2X1  g097(.A(Y_3), .B(n147), .Y(n230_1));
NAND3X1  g098(.A(Y_1), .B(Y_2), .C(Y_3), .Y(n231));
NAND4X1  g099(.A(Y_4), .B(n228), .C(X), .D(n231), .Y(n232));
OAI21X1  g100(.A0(n230_1), .A1(n229), .B0(n232), .Y(n75));
NAND2X1  g101(.A(Y_1), .B(Y_2), .Y(n234));
NAND4X1  g102(.A(Y_3), .B(n228), .C(X), .D(n234), .Y(n235));
OAI21X1  g103(.A0(n229), .A1(Y_3), .B0(n235), .Y(n80));
INVX1    g104(.A(Y_1), .Y(n237));
NOR3X1   g105(.A(n237), .B(Clear), .C(n150_1), .Y(n238));
NOR3X1   g106(.A(Y_1), .B(Clear), .C(n150_1), .Y(n90));
MX2X1    g107(.A(n238), .B(n90), .S0(Y_2), .Y(n85));
INVX1    g108(.A(Y_8), .Y(n241));
NOR4X1   g109(.A(n149), .B(n147), .C(Clear), .D(n231), .Y(n242));
NAND4X1  g110(.A(Y_6), .B(Y_7), .C(n241), .D(n242), .Y(n243));
NOR3X1   g111(.A(n231), .B(n147), .C(Clear), .Y(n244));
NAND3X1  g112(.A(Y_5), .B(Y_6), .C(Y_7), .Y(n245));
NAND3X1  g113(.A(n245), .B(n244), .C(Y_8), .Y(n246));
NAND2X1  g114(.A(n246), .B(n243), .Y(n95));
NAND2X1  g115(.A(n242), .B(Y_6), .Y(n248));
NAND2X1  g116(.A(Y_5), .B(Y_6), .Y(n249));
NAND3X1  g117(.A(n249), .B(n244), .C(Y_7), .Y(n250));
OAI21X1  g118(.A0(n248), .A1(Y_7), .B0(n250), .Y(n100));
NOR4X1   g119(.A(Y_5), .B(n147), .C(Clear), .D(n231), .Y(n110));
MX2X1    g120(.A(n242), .B(n110), .S0(Y_6), .Y(n105));
NOR3X1   g121(.A(n245), .B(n241), .C(Clear), .Y(n254));
AND2X1   g122(.A(n254), .B(Y_9), .Y(n255));
NAND4X1  g123(.A(Y_10), .B(Y_11), .C(n144), .D(n255), .Y(n256));
NAND3X1  g124(.A(Y_9), .B(Y_10), .C(Y_11), .Y(n257));
NAND3X1  g125(.A(n257), .B(n254), .C(Y_12), .Y(n258));
NAND2X1  g126(.A(n258), .B(n256), .Y(n115));
NAND2X1  g127(.A(Y_9), .B(Y_10), .Y(n260));
NAND3X1  g128(.A(n260), .B(n254), .C(Y_11), .Y(n261));
NAND4X1  g129(.A(Y_9), .B(Y_10), .C(n145_1), .D(n254), .Y(n262));
NAND2X1  g130(.A(n262), .B(n261), .Y(n120));
NOR4X1   g131(.A(Y_9), .B(n241), .C(Clear), .D(n245), .Y(n130));
MX2X1    g132(.A(n255), .B(n130), .S0(Y_10), .Y(n125));
NOR3X1   g133(.A(n257), .B(n144), .C(Clear), .Y(n266));
NAND3X1  g134(.A(n266), .B(Y_13), .C(Y_14), .Y(n267));
NAND2X1  g135(.A(Y_15), .B(n141), .Y(n268));
NAND3X1  g136(.A(Y_13), .B(Y_14), .C(Y_15), .Y(n269));
NAND3X1  g137(.A(n269), .B(n266), .C(Y_16), .Y(n270));
OAI21X1  g138(.A0(n268), .A1(n267), .B0(n270), .Y(n135));
NAND2X1  g139(.A(Y_13), .B(Y_14), .Y(n272));
NAND3X1  g140(.A(n272), .B(n266), .C(Y_15), .Y(n273));
OAI21X1  g141(.A0(n267), .A1(Y_15), .B0(n273), .Y(n140));
AND2X1   g142(.A(n266), .B(Y_13), .Y(n275));
NOR4X1   g143(.A(Y_13), .B(n144), .C(Clear), .D(n257), .Y(n150));
MX2X1    g144(.A(n275), .B(n150), .S0(Y_14), .Y(n145));
INVX1    g145(.A(Y_20), .Y(n278));
NOR4X1   g146(.A(n143), .B(n141), .C(Clear), .D(n269), .Y(n279));
NAND4X1  g147(.A(Y_18), .B(Y_19), .C(n278), .D(n279), .Y(n280));
NOR3X1   g148(.A(n269), .B(n141), .C(Clear), .Y(n281));
NAND3X1  g149(.A(Y_17), .B(Y_18), .C(Y_19), .Y(n282));
NAND3X1  g150(.A(n282), .B(n281), .C(Y_20), .Y(n283));
NAND2X1  g151(.A(n283), .B(n280), .Y(n155));
NAND2X1  g152(.A(n279), .B(Y_18), .Y(n285));
NAND2X1  g153(.A(Y_17), .B(Y_18), .Y(n286));
NAND3X1  g154(.A(n286), .B(n281), .C(Y_19), .Y(n287));
OAI21X1  g155(.A0(n285), .A1(Y_19), .B0(n287), .Y(n160));
NOR4X1   g156(.A(Y_17), .B(n141), .C(Clear), .D(n269), .Y(n170));
MX2X1    g157(.A(n279), .B(n170), .S0(Y_18), .Y(n165));
NOR3X1   g158(.A(n282), .B(n278), .C(Clear), .Y(n291));
AND2X1   g159(.A(n291), .B(Y_21), .Y(n292));
NAND4X1  g160(.A(Y_22), .B(Y_23), .C(n138), .D(n292), .Y(n293));
NAND3X1  g161(.A(Y_21), .B(Y_22), .C(Y_23), .Y(n294));
NAND3X1  g162(.A(n294), .B(n291), .C(Y_24), .Y(n295));
NAND2X1  g163(.A(n295), .B(n293), .Y(n175));
NAND2X1  g164(.A(Y_21), .B(Y_22), .Y(n297));
NAND3X1  g165(.A(n297), .B(n291), .C(Y_23), .Y(n298));
NAND4X1  g166(.A(Y_21), .B(Y_22), .C(n139), .D(n291), .Y(n299));
NAND2X1  g167(.A(n299), .B(n298), .Y(n180));
NOR4X1   g168(.A(Y_21), .B(n278), .C(Clear), .D(n282), .Y(n190));
MX2X1    g169(.A(n292), .B(n190), .S0(Y_22), .Y(n185));
NOR3X1   g170(.A(n294), .B(n138), .C(Clear), .Y(n303));
NAND3X1  g171(.A(n303), .B(Y_25), .C(Y_26), .Y(n304));
NAND2X1  g172(.A(Y_27), .B(n136), .Y(n305));
NAND3X1  g173(.A(Y_25), .B(Y_26), .C(Y_27), .Y(n306));
NAND3X1  g174(.A(n306), .B(n303), .C(Y_28), .Y(n307));
OAI21X1  g175(.A0(n305), .A1(n304), .B0(n307), .Y(n195));
NAND2X1  g176(.A(Y_25), .B(Y_26), .Y(n309));
NAND3X1  g177(.A(n309), .B(n303), .C(Y_27), .Y(n310));
OAI21X1  g178(.A0(n304), .A1(Y_27), .B0(n310), .Y(n200));
AND2X1   g179(.A(n303), .B(Y_25), .Y(n312));
NOR4X1   g180(.A(Y_25), .B(n138), .C(Clear), .D(n294), .Y(n210));
MX2X1    g181(.A(n312), .B(n210), .S0(Y_26), .Y(n205));
NOR4X1   g182(.A(n137), .B(n136), .C(Clear), .D(n306), .Y(n315));
NAND4X1  g183(.A(Y_30), .B(Y_31), .C(n133), .D(n315), .Y(n316));
NOR3X1   g184(.A(n306), .B(n136), .C(Clear), .Y(n317));
NAND3X1  g185(.A(n317), .B(n134), .C(Y_32), .Y(n318));
NAND2X1  g186(.A(n318), .B(n316), .Y(n215));
NAND2X1  g187(.A(n315), .B(Y_30), .Y(n320));
NAND2X1  g188(.A(Y_29), .B(Y_30), .Y(n321));
NAND3X1  g189(.A(n317), .B(n321), .C(Y_31), .Y(n322));
OAI21X1  g190(.A0(n320), .A1(Y_31), .B0(n322), .Y(n220));
NOR4X1   g191(.A(Y_29), .B(n136), .C(Clear), .D(n306), .Y(n230));
MX2X1    g192(.A(n315), .B(n230), .S0(Y_30), .Y(n225));
endmodule
