//Converted to Combinational (Partial output: n75) , Module name: s1494_n75 , Timestamp: 2018-12-03T15:51:02.660856 
module s1494_n75 ( v1, CLR, v7, v8, v2, v12, v9, v3, v11, v10, v0, v6, v5, v4, n75 );
input v1, CLR, v7, v8, v2, v12, v9, v3, v11, v10, v0, v6, v5, v4;
output n75;
wire n267, n387, n399, n68, n381, n386, n398, n391, n379, n380, n385, n62, n384, n397, n244, n396, n390, n93, n139, n388, n376, n378, n91, n325, n151, n53, n367, n116, n382, n383, n103, n70_1, n94, n392, n395, n394, n45, n389, n67, n84, n377, n46, n100, n87, n140, n107, n50, n190, n393, n342, n124;
AOI21X1  g354(.A0(n399), .A1(n387), .B0(n267), .Y(n75));
INVX1    g221(.A(CLR), .Y(n267));
OAI21X1  g341(.A0(n386), .A1(n381), .B0(n68), .Y(n387));
AOI21X1  g353(.A0(n391), .A1(v7), .B0(n398), .Y(n399));
INVX1    g023(.A(v7), .Y(n68));
AOI21X1  g335(.A0(n380), .A1(n379), .B0(v8), .Y(n381));
OAI21X1  g340(.A0(n384), .A1(n62), .B0(n385), .Y(n386));
OAI22X1  g352(.A0(n396), .A1(v2), .B0(n244), .B1(n397), .Y(n398));
OAI22X1  g345(.A0(n388), .A1(n139), .B0(n93), .B1(n390), .Y(n391));
OAI21X1  g333(.A0(n378), .A1(n376), .B0(v12), .Y(n379));
AOI22X1  g334(.A0(n151), .A1(n325), .B0(n91), .B1(v9), .Y(n380));
AOI22X1  g339(.A0(n116), .A1(n367), .B0(n53), .B1(v9), .Y(n385));
INVX1    g017(.A(v2), .Y(n62));
AOI21X1  g338(.A0(n383), .A1(n93), .B0(n382), .Y(n384));
AOI22X1  g351(.A0(n70_1), .A1(v12), .B0(v3), .B1(n103), .Y(n397));
INVX1    g198(.A(n94), .Y(n244));
AOI22X1  g350(.A0(n394), .A1(n395), .B0(n392), .B1(v8), .Y(n396));
MX2X1    g344(.A(n139), .B(n389), .S0(n45), .Y(n390));
INVX1    g048(.A(v8), .Y(n93));
NAND2X1  g093(.A(v11), .B(n67), .Y(n139));
MX2X1    g342(.A(n70_1), .B(v8), .S0(n45), .Y(n388));
NOR2X1   g330(.A(n45), .B(v11), .Y(n376));
AOI21X1  g332(.A0(n377), .A1(n84), .B0(v10), .Y(n378));
INVX1    g046(.A(n46), .Y(n91));
NOR2X1   g279(.A(n100), .B(v12), .Y(n325));
OAI21X1  g105(.A0(n140), .A1(v0), .B0(n87), .Y(n151));
AND2X1   g008(.A(v11), .B(v12), .Y(n53));
NOR2X1   g321(.A(n93), .B(v12), .Y(n367));
NOR2X1   g071(.A(v9), .B(v10), .Y(n116));
NOR3X1   g336(.A(n107), .B(v10), .C(v1), .Y(n382));
OAI21X1  g337(.A0(n50), .A1(v3), .B0(n70_1), .Y(n383));
NOR2X1   g058(.A(v10), .B(v12), .Y(n103));
INVX1    g025(.A(v9), .Y(n70_1));
NOR2X1   g049(.A(n93), .B(v11), .Y(n94));
OAI22X1  g346(.A0(n190), .A1(n68), .B0(n45), .B1(n139), .Y(n392));
NOR2X1   g349(.A(v7), .B(n84), .Y(n395));
OAI21X1  g348(.A0(n342), .A1(v10), .B0(n393), .Y(n394));
INVX1    g000(.A(v10), .Y(n45));
AOI21X1  g343(.A0(n70_1), .A1(v12), .B0(n84), .Y(n389));
INVX1    g022(.A(v12), .Y(n67));
INVX1    g039(.A(v11), .Y(n84));
OR2X1    g331(.A(v3), .B(v6), .Y(n377));
NOR3X1   g001(.A(n45), .B(v11), .C(v12), .Y(n46));
NAND2X1  g055(.A(v4), .B(v5), .Y(n100));
OR2X1    g042(.A(v10), .B(v11), .Y(n87));
NAND2X1  g094(.A(v10), .B(v11), .Y(n140));
NAND2X1  g062(.A(v11), .B(v12), .Y(n107));
NAND2X1  g005(.A(v10), .B(v12), .Y(n50));
NAND2X1  g144(.A(n70_1), .B(v12), .Y(n190));
NAND3X1  g347(.A(n124), .B(v8), .C(n67), .Y(n393));
NAND2X1  g296(.A(v12), .B(v1), .Y(n342));
AND2X1   g078(.A(v4), .B(v5), .Y(n124));

endmodule
