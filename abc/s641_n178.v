//Converted to Combinational (Partial output: n178) , Module name: s641_n178
module s641_n178 ( G5, G2, G75, G3, G71, G76, G64, G4, G72, G77, G65, G13, G9, G10, G22, G11, G78, G23, G67, G66, G24, G25, n178 );
input G5, G2, G75, G3, G71, G76, G64, G4, G72, G77, G65, G13, G9, G10, G22, G11, G78, G23, G67, G66, G24, G25;
output n178;
wire n216, n119, n215, n152, n154, n179, n137, G86BF, n214, n148_1, n204, n129, n151, n175, n171, n172, n124_1, n147, n188_1, n163_1, n164, n135, n173_1, n174, n145, n146, n156, n160, n134_1, n131, n133, n139_1, n141, n155, n158_1, n159, n132, n138, n140, n157;
OAI21X1  g101(.A0(n215), .A1(n119), .B0(n216), .Y(n178));
OAI21X1  g100(.A0(G5), .A1(n154), .B0(n152), .Y(n216));
AOI21X1  g064(.A0(G86BF), .A1(n137), .B0(n179), .Y(n119));
OR4X1    g099(.A(n129), .B(n204), .C(n148_1), .D(n214), .Y(n215));
INVX1    g036(.A(n151), .Y(n152));
INVX1    g038(.A(G2), .Y(n154));
INVX1    g063(.A(G75), .Y(n179));
INVX1    g021(.A(G3), .Y(n137));
OAI21X1  g060(.A0(n172), .A1(n171), .B0(n175), .Y(G86BF));
NAND3X1  g098(.A(G71), .B(G5), .C(n124_1), .Y(n214));
INVX1    g032(.A(n147), .Y(n148_1));
INVX1    g088(.A(n188_1), .Y(n204));
NOR2X1   g049(.A(n164), .B(n163_1), .Y(n129));
OAI21X1  g035(.A0(n135), .A1(G3), .B0(G76), .Y(n151));
NOR2X1   g059(.A(n174), .B(n173_1), .Y(n175));
OAI21X1  g055(.A0(n164), .A1(n163_1), .B0(n147), .Y(n171));
NAND3X1  g056(.A(n151), .B(G64), .C(n154), .Y(n172));
INVX1    g008(.A(G4), .Y(n124_1));
OR2X1    g031(.A(n146), .B(n145), .Y(n147));
AND2X1   g072(.A(n135), .B(G72), .Y(n188_1));
INVX1    g047(.A(G77), .Y(n163_1));
AOI21X1  g048(.A0(n160), .A1(n156), .B0(G3), .Y(n164));
NOR4X1   g019(.A(n133), .B(G65), .C(n131), .D(n134_1), .Y(n135));
NOR4X1   g057(.A(G10), .B(G9), .C(G3), .D(G13), .Y(n173_1));
OAI21X1  g058(.A0(G11), .A1(G3), .B0(G22), .Y(n174));
INVX1    g029(.A(G78), .Y(n145));
AOI21X1  g030(.A0(n141), .A1(n139_1), .B0(G3), .Y(n146));
OAI21X1  g040(.A0(n146), .A1(n145), .B0(n155), .Y(n156));
NOR2X1   g044(.A(n159), .B(n158_1), .Y(n160));
NOR2X1   g018(.A(G11), .B(G3), .Y(n134_1));
INVX1    g015(.A(G23), .Y(n131));
NOR4X1   g017(.A(n132), .B(G9), .C(G3), .D(G13), .Y(n133));
NAND4X1  g023(.A(G10), .B(G9), .C(n137), .D(n138), .Y(n139_1));
NOR3X1   g025(.A(n134_1), .B(G67), .C(n140), .Y(n141));
AND2X1   g039(.A(G66), .B(n154), .Y(n155));
NOR4X1   g042(.A(G10), .B(n157), .C(G3), .D(G13), .Y(n158_1));
OAI21X1  g043(.A0(G11), .A1(G3), .B0(G24), .Y(n159));
INVX1    g016(.A(G10), .Y(n132));
INVX1    g022(.A(G13), .Y(n138));
INVX1    g024(.A(G25), .Y(n140));
INVX1    g041(.A(G9), .Y(n157));

endmodule
