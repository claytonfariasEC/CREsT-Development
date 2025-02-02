// Benchmark "c499.blif" written by ABC on Thu Jun 15 03:40:38 2017

module c499.blif ( 
    Gid0, Gid1, Gid2, Gid3, Gid4, Gid5, Gid6, Gid7, Gid8, Gid9, Gid10,
    Gid11, Gid12, Gid13, Gid14, Gid15, Gid16, Gid17, Gid18, Gid19, Gid20,
    Gid21, Gid22, Gid23, Gid24, Gid25, Gid26, Gid27, Gid28, Gid29, Gid30,
    Gid31, Gic0, Gic1, Gic2, Gic3, Gic4, Gic5, Gic6, Gic7, Gr,
    God0, God1, God2, God3, God4, God5, God6, God7, God8, God9, God10,
    God11, God12, God13, God14, God15, God16, God17, God18, God19, God20,
    God21, God22, God23, God24, God25, God26, God27, God28, God29, God30,
    God31  );
  input  Gid0, Gid1, Gid2, Gid3, Gid4, Gid5, Gid6, Gid7, Gid8, Gid9,
    Gid10, Gid11, Gid12, Gid13, Gid14, Gid15, Gid16, Gid17, Gid18, Gid19,
    Gid20, Gid21, Gid22, Gid23, Gid24, Gid25, Gid26, Gid27, Gid28, Gid29,
    Gid30, Gid31, Gic0, Gic1, Gic2, Gic3, Gic4, Gic5, Gic6, Gic7, Gr;
  output God0, God1, God2, God3, God4, God5, God6, God7, God8, God9, God10,
    God11, God12, God13, God14, God15, God16, God17, God18, God19, God20,
    God21, God22, God23, God24, God25, God26, God27, God28, God29, God30,
    God31;
  wire n73, n74, n75, n76, n77, n78, n79, n80, n81, n82, n83, n84, n85, n86,
    n87, n88, n89, n90, n91, n92, n93, n94, n95, n96, n97, n98, n99, n100,
    n101, n102, n103, n104, n105, n106, n107, n108, n109, n110, n111, n112,
    n113, n114, n115, n116, n117, n118, n119, n120, n121, n122, n123, n124,
    n125, n126, n127, n128, n129, n130, n131, n132, n133, n134, n135, n136,
    n137, n138, n139, n140, n141, n142, n143, n144, n145, n146, n147, n148,
    n149, n150, n151, n152, n153, n154, n155, n156, n157, n158, n159, n160,
    n161, n162, n163, n164, n165, n166, n167, n168, n169, n170, n171, n172,
    n173, n174, n176, n178, n180, n182, n183, n184, n185, n186, n187, n188,
    n189, n190, n191, n193, n195, n197, n199, n200, n202, n204, n206, n208,
    n209, n211, n213, n215, n217, n218, n219, n220, n221, n222, n223, n224,
    n225, n226, n228, n230, n232, n234, n235, n237, n239, n241, n243, n244,
    n246, n248, n250, n252, n253, n255, n257, n259;
  XOR2X1   g000(.A(Gid4), .B(Gid0), .Y(n73));
  XOR2X1   g001(.A(Gid12), .B(Gid8), .Y(n74));
  XOR2X1   g002(.A(n74), .B(n73), .Y(n75));
  AND2X1   g003(.A(Gr), .B(Gic0), .Y(n76));
  INVX1    g004(.A(n76), .Y(n77));
  XOR2X1   g005(.A(Gid17), .B(Gid16), .Y(n78));
  XOR2X1   g006(.A(Gid19), .B(Gid18), .Y(n79));
  XOR2X1   g007(.A(n79), .B(n78), .Y(n80));
  XOR2X1   g008(.A(Gid21), .B(Gid20), .Y(n81));
  XOR2X1   g009(.A(Gid23), .B(Gid22), .Y(n82));
  XOR2X1   g010(.A(n82), .B(n81), .Y(n83));
  XOR2X1   g011(.A(n83), .B(n80), .Y(n84));
  XOR2X1   g012(.A(n84), .B(n77), .Y(n85));
  XOR2X1   g013(.A(n85), .B(n75), .Y(n86));
  XOR2X1   g014(.A(n84), .B(n76), .Y(n87));
  XOR2X1   g015(.A(n87), .B(n75), .Y(n88));
  XOR2X1   g016(.A(Gid7), .B(Gid3), .Y(n89));
  XOR2X1   g017(.A(Gid15), .B(Gid11), .Y(n90));
  XOR2X1   g018(.A(n90), .B(n89), .Y(n91));
  AND2X1   g019(.A(Gr), .B(Gic3), .Y(n92));
  XOR2X1   g020(.A(Gid29), .B(Gid28), .Y(n93));
  XOR2X1   g021(.A(Gid31), .B(Gid30), .Y(n94));
  XOR2X1   g022(.A(n94), .B(n93), .Y(n95));
  XOR2X1   g023(.A(n95), .B(n83), .Y(n96));
  XOR2X1   g024(.A(n96), .B(n92), .Y(n97));
  XOR2X1   g025(.A(n97), .B(n91), .Y(n98));
  XOR2X1   g026(.A(Gid6), .B(Gid2), .Y(n99));
  XOR2X1   g027(.A(Gid14), .B(Gid10), .Y(n100));
  XOR2X1   g028(.A(n100), .B(n99), .Y(n101));
  AND2X1   g029(.A(Gr), .B(Gic2), .Y(n102));
  XOR2X1   g030(.A(Gid25), .B(Gid24), .Y(n103));
  XOR2X1   g031(.A(Gid27), .B(Gid26), .Y(n104));
  XOR2X1   g032(.A(n104), .B(n103), .Y(n105));
  XOR2X1   g033(.A(n105), .B(n80), .Y(n106));
  XOR2X1   g034(.A(n106), .B(n102), .Y(n107));
  XOR2X1   g035(.A(n107), .B(n101), .Y(n108));
  XOR2X1   g036(.A(Gid5), .B(Gid1), .Y(n109));
  XOR2X1   g037(.A(Gid13), .B(Gid9), .Y(n110));
  XOR2X1   g038(.A(n110), .B(n109), .Y(n111));
  AND2X1   g039(.A(Gr), .B(Gic1), .Y(n112));
  INVX1    g040(.A(n112), .Y(n113));
  XOR2X1   g041(.A(n105), .B(n95), .Y(n114));
  XOR2X1   g042(.A(n114), .B(n113), .Y(n115));
  XOR2X1   g043(.A(n115), .B(n111), .Y(n116));
  NOR4X1   g044(.A(n116), .B(n108), .C(n98), .D(n88), .Y(n117));
  XOR2X1   g045(.A(n114), .B(n112), .Y(n118));
  XOR2X1   g046(.A(n118), .B(n111), .Y(n119));
  NOR4X1   g047(.A(n119), .B(n108), .C(n98), .D(n86), .Y(n120));
  INVX1    g048(.A(n92), .Y(n121));
  XOR2X1   g049(.A(n96), .B(n121), .Y(n122));
  XOR2X1   g050(.A(n122), .B(n91), .Y(n123));
  NOR4X1   g051(.A(n119), .B(n108), .C(n123), .D(n88), .Y(n124));
  INVX1    g052(.A(n102), .Y(n125));
  XOR2X1   g053(.A(n106), .B(n125), .Y(n126));
  XOR2X1   g054(.A(n126), .B(n101), .Y(n127));
  NOR4X1   g055(.A(n119), .B(n127), .C(n98), .D(n88), .Y(n128));
  NOR4X1   g056(.A(n128), .B(n124), .C(n120), .D(n117), .Y(n129));
  XOR2X1   g057(.A(Gid20), .B(Gid16), .Y(n130));
  XOR2X1   g058(.A(Gid28), .B(Gid24), .Y(n131));
  XOR2X1   g059(.A(n131), .B(n130), .Y(n132));
  AND2X1   g060(.A(Gr), .B(Gic4), .Y(n133));
  INVX1    g061(.A(n133), .Y(n134));
  XOR2X1   g062(.A(Gid5), .B(Gid4), .Y(n135));
  XOR2X1   g063(.A(Gid7), .B(Gid6), .Y(n136));
  XOR2X1   g064(.A(n136), .B(n135), .Y(n137));
  XOR2X1   g065(.A(Gid1), .B(Gid0), .Y(n138));
  XOR2X1   g066(.A(Gid3), .B(Gid2), .Y(n139));
  XOR2X1   g067(.A(n139), .B(n138), .Y(n140));
  XOR2X1   g068(.A(n140), .B(n137), .Y(n141));
  XOR2X1   g069(.A(n141), .B(n134), .Y(n142));
  XOR2X1   g070(.A(n142), .B(n132), .Y(n143));
  XOR2X1   g071(.A(Gid21), .B(Gid17), .Y(n144));
  XOR2X1   g072(.A(Gid29), .B(Gid25), .Y(n145));
  XOR2X1   g073(.A(n145), .B(n144), .Y(n146));
  AND2X1   g074(.A(Gr), .B(Gic5), .Y(n147));
  XOR2X1   g075(.A(Gid13), .B(Gid12), .Y(n148));
  XOR2X1   g076(.A(Gid15), .B(Gid14), .Y(n149));
  XOR2X1   g077(.A(n149), .B(n148), .Y(n150));
  XOR2X1   g078(.A(Gid9), .B(Gid8), .Y(n151));
  XOR2X1   g079(.A(Gid11), .B(Gid10), .Y(n152));
  XOR2X1   g080(.A(n152), .B(n151), .Y(n153));
  XOR2X1   g081(.A(n153), .B(n150), .Y(n154));
  XOR2X1   g082(.A(n154), .B(n147), .Y(n155));
  XOR2X1   g083(.A(n155), .B(n146), .Y(n156));
  OR2X1    g084(.A(n156), .B(n143), .Y(n157));
  XOR2X1   g085(.A(Gid23), .B(Gid19), .Y(n158));
  XOR2X1   g086(.A(Gid31), .B(Gid27), .Y(n159));
  XOR2X1   g087(.A(n159), .B(n158), .Y(n160));
  AND2X1   g088(.A(Gr), .B(Gic7), .Y(n161));
  XOR2X1   g089(.A(n150), .B(n137), .Y(n162));
  XOR2X1   g090(.A(n162), .B(n161), .Y(n163));
  XOR2X1   g091(.A(n163), .B(n160), .Y(n164));
  XOR2X1   g092(.A(Gid22), .B(Gid18), .Y(n165));
  XOR2X1   g093(.A(Gid30), .B(Gid26), .Y(n166));
  XOR2X1   g094(.A(n166), .B(n165), .Y(n167));
  AND2X1   g095(.A(Gr), .B(Gic6), .Y(n168));
  INVX1    g096(.A(n168), .Y(n169));
  XOR2X1   g097(.A(n153), .B(n140), .Y(n170));
  XOR2X1   g098(.A(n170), .B(n169), .Y(n171));
  XOR2X1   g099(.A(n171), .B(n167), .Y(n172));
  OR2X1    g100(.A(n172), .B(n164), .Y(n173));
  NOR4X1   g101(.A(n173), .B(n157), .C(n129), .D(n86), .Y(n174));
  XOR2X1   g102(.A(n174), .B(Gid0), .Y(God0));
  NOR4X1   g103(.A(n173), .B(n157), .C(n129), .D(n116), .Y(n176));
  XOR2X1   g104(.A(n176), .B(Gid1), .Y(God1));
  NOR4X1   g105(.A(n173), .B(n157), .C(n129), .D(n127), .Y(n178));
  XOR2X1   g106(.A(n178), .B(Gid2), .Y(God2));
  NOR4X1   g107(.A(n173), .B(n157), .C(n129), .D(n123), .Y(n180));
  XOR2X1   g108(.A(n180), .B(Gid3), .Y(God3));
  INVX1    g109(.A(n161), .Y(n182));
  XOR2X1   g110(.A(n162), .B(n182), .Y(n183));
  XOR2X1   g111(.A(n183), .B(n160), .Y(n184));
  XOR2X1   g112(.A(n141), .B(n133), .Y(n185));
  XOR2X1   g113(.A(n185), .B(n132), .Y(n186));
  INVX1    g114(.A(n147), .Y(n187));
  XOR2X1   g115(.A(n154), .B(n187), .Y(n188));
  XOR2X1   g116(.A(n188), .B(n146), .Y(n189));
  NAND3X1  g117(.A(n172), .B(n189), .C(n186), .Y(n190));
  NOR4X1   g118(.A(n190), .B(n184), .C(n129), .D(n86), .Y(n191));
  XOR2X1   g119(.A(n191), .B(Gid4), .Y(God4));
  NOR4X1   g120(.A(n190), .B(n184), .C(n129), .D(n116), .Y(n193));
  XOR2X1   g121(.A(n193), .B(Gid5), .Y(God5));
  NOR4X1   g122(.A(n190), .B(n184), .C(n129), .D(n127), .Y(n195));
  XOR2X1   g123(.A(n195), .B(Gid6), .Y(God6));
  NOR4X1   g124(.A(n190), .B(n184), .C(n129), .D(n123), .Y(n197));
  XOR2X1   g125(.A(n197), .B(Gid7), .Y(God7));
  OR2X1    g126(.A(n189), .B(n186), .Y(n199));
  NOR4X1   g127(.A(n199), .B(n173), .C(n129), .D(n86), .Y(n200));
  XOR2X1   g128(.A(n200), .B(Gid8), .Y(God8));
  NOR4X1   g129(.A(n199), .B(n173), .C(n129), .D(n116), .Y(n202));
  XOR2X1   g130(.A(n202), .B(Gid9), .Y(God9));
  NOR4X1   g131(.A(n199), .B(n173), .C(n129), .D(n127), .Y(n204));
  XOR2X1   g132(.A(n204), .B(Gid10), .Y(God10));
  NOR4X1   g133(.A(n199), .B(n173), .C(n129), .D(n123), .Y(n206));
  XOR2X1   g134(.A(n206), .B(Gid11), .Y(God11));
  NAND3X1  g135(.A(n172), .B(n156), .C(n143), .Y(n208));
  NOR4X1   g136(.A(n208), .B(n184), .C(n129), .D(n86), .Y(n209));
  XOR2X1   g137(.A(n209), .B(Gid12), .Y(God12));
  NOR4X1   g138(.A(n208), .B(n184), .C(n129), .D(n116), .Y(n211));
  XOR2X1   g139(.A(n211), .B(Gid13), .Y(God13));
  NOR4X1   g140(.A(n208), .B(n184), .C(n129), .D(n127), .Y(n213));
  XOR2X1   g141(.A(n213), .B(Gid14), .Y(God14));
  NOR4X1   g142(.A(n208), .B(n184), .C(n129), .D(n123), .Y(n215));
  XOR2X1   g143(.A(n215), .B(Gid15), .Y(God15));
  OR2X1    g144(.A(n119), .B(n86), .Y(n217));
  OR2X1    g145(.A(n127), .B(n98), .Y(n218));
  XOR2X1   g146(.A(n170), .B(n168), .Y(n219));
  XOR2X1   g147(.A(n219), .B(n167), .Y(n220));
  NOR4X1   g148(.A(n220), .B(n164), .C(n189), .D(n186), .Y(n221));
  NOR4X1   g149(.A(n220), .B(n164), .C(n156), .D(n143), .Y(n222));
  NOR4X1   g150(.A(n220), .B(n184), .C(n156), .D(n186), .Y(n223));
  NOR4X1   g151(.A(n172), .B(n164), .C(n156), .D(n186), .Y(n224));
  NOR4X1   g152(.A(n224), .B(n223), .C(n222), .D(n221), .Y(n225));
  NOR4X1   g153(.A(n225), .B(n143), .C(n218), .D(n217), .Y(n226));
  XOR2X1   g154(.A(n226), .B(Gid16), .Y(God16));
  NOR4X1   g155(.A(n225), .B(n189), .C(n218), .D(n217), .Y(n228));
  XOR2X1   g156(.A(n228), .B(Gid17), .Y(God17));
  NOR4X1   g157(.A(n225), .B(n172), .C(n218), .D(n217), .Y(n230));
  XOR2X1   g158(.A(n230), .B(Gid18), .Y(God18));
  NOR4X1   g159(.A(n225), .B(n184), .C(n218), .D(n217), .Y(n232));
  XOR2X1   g160(.A(n232), .B(Gid19), .Y(God19));
  NAND3X1  g161(.A(n116), .B(n127), .C(n88), .Y(n234));
  NOR4X1   g162(.A(n225), .B(n143), .C(n234), .D(n123), .Y(n235));
  XOR2X1   g163(.A(n235), .B(Gid20), .Y(God20));
  NOR4X1   g164(.A(n225), .B(n189), .C(n234), .D(n123), .Y(n237));
  XOR2X1   g165(.A(n237), .B(Gid21), .Y(God21));
  NOR4X1   g166(.A(n225), .B(n172), .C(n234), .D(n123), .Y(n239));
  XOR2X1   g167(.A(n239), .B(Gid22), .Y(God22));
  NOR4X1   g168(.A(n225), .B(n184), .C(n234), .D(n123), .Y(n241));
  XOR2X1   g169(.A(n241), .B(Gid23), .Y(God23));
  OR2X1    g170(.A(n116), .B(n88), .Y(n243));
  NOR4X1   g171(.A(n225), .B(n143), .C(n218), .D(n243), .Y(n244));
  XOR2X1   g172(.A(n244), .B(Gid24), .Y(God24));
  NOR4X1   g173(.A(n225), .B(n189), .C(n218), .D(n243), .Y(n246));
  XOR2X1   g174(.A(n246), .B(Gid25), .Y(God25));
  NOR4X1   g175(.A(n225), .B(n172), .C(n218), .D(n243), .Y(n248));
  XOR2X1   g176(.A(n248), .B(Gid26), .Y(God26));
  NOR4X1   g177(.A(n225), .B(n184), .C(n218), .D(n243), .Y(n250));
  XOR2X1   g178(.A(n250), .B(Gid27), .Y(God27));
  NAND3X1  g179(.A(n119), .B(n127), .C(n86), .Y(n252));
  NOR4X1   g180(.A(n225), .B(n143), .C(n252), .D(n123), .Y(n253));
  XOR2X1   g181(.A(n253), .B(Gid28), .Y(God28));
  NOR4X1   g182(.A(n225), .B(n189), .C(n252), .D(n123), .Y(n255));
  XOR2X1   g183(.A(n255), .B(Gid29), .Y(God29));
  NOR4X1   g184(.A(n225), .B(n172), .C(n252), .D(n123), .Y(n257));
  XOR2X1   g185(.A(n257), .B(Gid30), .Y(God30));
  NOR4X1   g186(.A(n225), .B(n184), .C(n252), .D(n123), .Y(n259));
  XOR2X1   g187(.A(n259), .B(Gid31), .Y(God31));
endmodule


