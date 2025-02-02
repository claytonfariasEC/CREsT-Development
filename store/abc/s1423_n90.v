//Converted to Combinational (Partial output: n90) , Module name: s1423_n90
module s1423_n90 ( G1, G2, G3, G4, G8, G14, G31, G30, G29, G92, G28, G27, G24, G25, G26, G46, G90, G45, G84, G78, G85, G44, G64, G77, G76, G43, G42, G0, G75, G74, n90 );
input G1, G2, G3, G4, G8, G14, G31, G30, G29, G92, G28, G27, G24, G25, G26, G46, G90, G45, G84, G78, G85, G44, G64, G77, G76, G43, G42, G0, G75, G74;
output n90;
wire n331, n376, n377, n373, n293, n292, n247, n291, n290_1, n248, n249, n260_1, n262, n289, n258, n259, n261, n267, n269, n288, n257, n250_1, n251, n254, n266, n268, n273, n275_1, n287, n255_1, n256, n252, n253, n264, n265_1, n271, n272, n274, n280_1, n281, n286, n263, n270_1, n276, n278, n279, n282, n284, n285_1, n277, n283;
NOR3X1   g134(.A(n377), .B(n376), .C(n331), .Y(n90));
INVX1    g087(.A(G14), .Y(n331));
AND2X1   g132(.A(n373), .B(G31), .Y(n376));
AOI21X1  g133(.A0(n293), .A1(G30), .B0(G31), .Y(n377));
AND2X1   g129(.A(n293), .B(G30), .Y(n373));
AOI21X1  g049(.A0(n292), .A1(G92), .B0(G29), .Y(n293));
NAND3X1  g048(.A(n291), .B(G28), .C(n247), .Y(n292));
INVX1    g003(.A(G27), .Y(n247));
NOR4X1   g047(.A(n249), .B(n248), .C(G24), .D(n290_1), .Y(n291));
AOI21X1  g046(.A0(n289), .A1(n262), .B0(n260_1), .Y(n290_1));
INVX1    g004(.A(G25), .Y(n248));
INVX1    g005(.A(G26), .Y(n249));
AOI21X1  g016(.A0(n259), .A1(n258), .B0(G46), .Y(n260_1));
XOR2X1   g018(.A(n261), .B(G46), .Y(n262));
OAI21X1  g045(.A0(n288), .A1(n269), .B0(n267), .Y(n289));
OR4X1    g014(.A(n254), .B(n251), .C(n250_1), .D(n257), .Y(n258));
OR2X1    g015(.A(G90), .B(G4), .Y(n259));
AND2X1   g017(.A(n259), .B(n258), .Y(n261));
OR2X1    g023(.A(n266), .B(G45), .Y(n267));
XOR2X1   g025(.A(n266), .B(n268), .Y(n269));
AOI21X1  g044(.A0(n287), .A1(n275_1), .B0(n273), .Y(n288));
NOR3X1   g013(.A(n256), .B(n255_1), .C(G84), .Y(n257));
INVX1    g006(.A(G78), .Y(n250_1));
INVX1    g007(.A(G90), .Y(n251));
AOI21X1  g010(.A0(n253), .A1(n252), .B0(G85), .Y(n254));
AND2X1   g022(.A(n265_1), .B(n264), .Y(n266));
INVX1    g024(.A(G45), .Y(n268));
AOI21X1  g029(.A0(n272), .A1(n271), .B0(G44), .Y(n273));
XOR2X1   g031(.A(n274), .B(G44), .Y(n275_1));
OAI21X1  g043(.A0(n286), .A1(n281), .B0(n280_1), .Y(n287));
AND2X1   g011(.A(G90), .B(G64), .Y(n255_1));
NOR2X1   g012(.A(G90), .B(G8), .Y(n256));
NAND2X1  g008(.A(G90), .B(G64), .Y(n252));
OR2X1    g009(.A(G90), .B(G8), .Y(n253));
OR4X1    g020(.A(n254), .B(n251), .C(n263), .D(n257), .Y(n264));
OR2X1    g021(.A(G90), .B(G3), .Y(n265_1));
OR4X1    g027(.A(n254), .B(n251), .C(n270_1), .D(n257), .Y(n271));
OR2X1    g028(.A(G90), .B(G2), .Y(n272));
AND2X1   g030(.A(n272), .B(n271), .Y(n274));
OAI21X1  g036(.A0(n279), .A1(n278), .B0(n276), .Y(n280_1));
NOR3X1   g037(.A(n279), .B(n278), .C(n276), .Y(n281));
NOR3X1   g042(.A(n285_1), .B(n284), .C(n282), .Y(n286));
INVX1    g019(.A(G77), .Y(n263));
INVX1    g026(.A(G76), .Y(n270_1));
INVX1    g032(.A(G43), .Y(n276));
NOR3X1   g034(.A(n277), .B(n257), .C(n254), .Y(n278));
NOR2X1   g035(.A(G90), .B(G1), .Y(n279));
INVX1    g038(.A(G42), .Y(n282));
NOR3X1   g040(.A(n283), .B(n257), .C(n254), .Y(n284));
NOR2X1   g041(.A(G90), .B(G0), .Y(n285_1));
NAND2X1  g033(.A(G90), .B(G75), .Y(n277));
NAND2X1  g039(.A(G90), .B(G74), .Y(n283));

endmodule
