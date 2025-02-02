//Converted to Combinational (Partial output: n60) , Module name: s1494_n60 , Timestamp: 2018-12-03T15:51:02.654859 
module s1494_n60 ( v1, CLR, v7, v10, v8, v9, v11, v2, v12, v6, v3, v5, v4, v0, n60 );
input v1, CLR, v7, v10, v8, v9, v11, v2, v12, v6, v3, v5, v4, v0;
output n60;
wire n267, n309, n316, n68, n300, n308, n312, n315, n93, n295, n299, n51, n303, n307, n62, n310, n311, n314, n77, n313, n84, n294, n298, n95, n296, n50, n67, n302, n306, n86, n305, n112, n45, n107, n103, n96, n203, n94, n76, n178, n160, n119, n293, n297, n124, n301, n140, n70_1, n165, n190, n104, n304, n139, n83, n174;
AOI21X1  g271(.A0(n316), .A1(n309), .B0(n267), .Y(n60));
INVX1    g221(.A(CLR), .Y(n267));
OAI21X1  g263(.A0(n308), .A1(n300), .B0(n68), .Y(n309));
NOR2X1   g270(.A(n315), .B(n312), .Y(n316));
INVX1    g023(.A(v7), .Y(n68));
AOI21X1  g254(.A0(n299), .A1(n295), .B0(n93), .Y(n300));
NAND3X1  g262(.A(n307), .B(n303), .C(n51), .Y(n308));
AOI21X1  g266(.A0(n311), .A1(n310), .B0(n62), .Y(n312));
OAI22X1  g269(.A0(n313), .A1(n77), .B0(v10), .B1(n314), .Y(n315));
INVX1    g048(.A(v8), .Y(n93));
OAI21X1  g249(.A0(n294), .A1(n84), .B0(v9), .Y(n295));
AOI21X1  g253(.A0(n296), .A1(n95), .B0(n298), .Y(n299));
OR2X1    g006(.A(n50), .B(v11), .Y(n51));
NAND3X1  g257(.A(n302), .B(n93), .C(n67), .Y(n303));
AOI21X1  g261(.A0(n305), .A1(n86), .B0(n306), .Y(n307));
INVX1    g017(.A(v2), .Y(n62));
OR4X1    g264(.A(n107), .B(v9), .C(n45), .D(n112), .Y(n310));
NAND3X1  g265(.A(n103), .B(n68), .C(v9), .Y(n311));
AOI22X1  g268(.A0(n94), .A1(v12), .B0(n203), .B1(n96), .Y(n314));
INVX1    g032(.A(n76), .Y(n77));
AOI22X1  g267(.A0(n160), .A1(n94), .B0(v11), .B1(n178), .Y(n313));
INVX1    g039(.A(v11), .Y(n84));
NOR3X1   g248(.A(n293), .B(n67), .C(n119), .Y(n294));
OAI22X1  g252(.A0(v10), .A1(n297), .B0(v11), .B1(n67), .Y(n298));
NOR2X1   g050(.A(v12), .B(v2), .Y(n95));
MX2X1    g250(.A(v10), .B(n124), .S0(v9), .Y(n296));
NAND2X1  g005(.A(v10), .B(v12), .Y(n50));
INVX1    g022(.A(v12), .Y(n67));
OAI21X1  g256(.A0(n140), .A1(v9), .B0(n301), .Y(n302));
NOR2X1   g260(.A(n165), .B(n70_1), .Y(n306));
INVX1    g041(.A(v6), .Y(n86));
OAI22X1  g259(.A0(n304), .A1(n104), .B0(n190), .B1(v11), .Y(n305));
NAND2X1  g067(.A(v7), .B(v8), .Y(n112));
INVX1    g000(.A(v10), .Y(n45));
NAND2X1  g062(.A(v11), .B(v12), .Y(n107));
NOR2X1   g058(.A(v10), .B(v12), .Y(n103));
NOR2X1   g051(.A(v8), .B(n70_1), .Y(n96));
INVX1    g157(.A(n139), .Y(n203));
NOR2X1   g049(.A(n93), .B(v11), .Y(n94));
NOR2X1   g031(.A(n68), .B(v12), .Y(n76));
NOR2X1   g132(.A(v8), .B(v10), .Y(n178));
NOR2X1   g114(.A(v9), .B(n45), .Y(n160));
INVX1    g073(.A(v3), .Y(n119));
NOR3X1   g247(.A(n83), .B(v1), .C(n86), .Y(n293));
AOI21X1  g251(.A0(n70_1), .A1(n119), .B0(n139), .Y(n297));
AND2X1   g078(.A(v4), .B(v5), .Y(n124));
NAND3X1  g255(.A(v9), .B(n45), .C(n174), .Y(n301));
NAND2X1  g094(.A(v10), .B(v11), .Y(n140));
INVX1    g025(.A(v9), .Y(n70_1));
MX2X1    g119(.A(v11), .B(n107), .S0(n45), .Y(n165));
NAND2X1  g144(.A(n70_1), .B(v12), .Y(n190));
INVX1    g059(.A(n103), .Y(n104));
NAND2X1  g258(.A(n93), .B(v9), .Y(n304));
NAND2X1  g093(.A(v11), .B(n67), .Y(n139));
INVX1    g038(.A(v0), .Y(n83));
INVX1    g128(.A(v1), .Y(n174));

endmodule
