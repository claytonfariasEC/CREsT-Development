//Converted to Combinational (Partial output: n5895) , Module name: s38584_n5895 , Timestamp: 2018-12-03T15:51:17.721156 
module s38584_n5895 ( g35, g142, g146, g691, g174, g168, g182, g718, g753, g655, g513, g807, g554, g370, g518, g499, g490, g528, g482, g203, g385, g358, g376, n5895 );
input g35, g142, g146, g691, g174, g168, g182, g718, g753, g655, g513, g807, g554, g370, g518, g499, g490, g528, g482, g203, g385, g358, g376;
output n5895;
wire n9828, n9826, n9827, n7302_1, n5661, n7300, n7303, n7301, n5660_1, n5655_1, n5657, n5658, n7299, n5659, n5347, n5320, n5601, n5656, n5132, n5142, n5130_1, n7298_1, n5129, n5600, n5598, n5599;
MX2X1    g5180(.A(g142), .B(n9828), .S0(g35), .Y(n5895));
NAND2X1  g5179(.A(n9827), .B(n9826), .Y(n9828));
OR4X1    g5177(.A(n7300), .B(n5661), .C(g146), .D(n7302_1), .Y(n9826));
NAND3X1  g5178(.A(n7303), .B(n7300), .C(g146), .Y(n9827));
OAI21X1  g2657(.A0(n7301), .A1(n7300), .B0(g691), .Y(n7302_1));
NOR4X1   g1021(.A(n5658), .B(n5657), .C(n5655_1), .D(n5660_1), .Y(n5661));
INVX1    g2655(.A(n7299), .Y(n7300));
NOR2X1   g2658(.A(n7302_1), .B(n5661), .Y(n7303));
NOR3X1   g2656(.A(g182), .B(g168), .C(g174), .Y(n7301));
OAI21X1  g1020(.A0(n5320), .A1(n5347), .B0(n5659), .Y(n5660_1));
INVX1    g1015(.A(n5601), .Y(n5655_1));
NAND4X1  g1017(.A(n5130_1), .B(n5142), .C(n5132), .D(n5656), .Y(n5657));
NOR3X1   g1018(.A(g655), .B(g753), .C(g718), .Y(n5658));
NOR3X1   g2654(.A(n5129), .B(g513), .C(n7298_1), .Y(n7299));
NAND3X1  g1019(.A(g655), .B(g753), .C(g718), .Y(n5659));
INVX1    g0707(.A(g807), .Y(n5347));
INVX1    g0680(.A(g554), .Y(n5320));
NOR4X1   g0961(.A(n5599), .B(g370), .C(n5598), .D(n5600), .Y(n5601));
NOR2X1   g1016(.A(g499), .B(g518), .Y(n5656));
INVX1    g0500(.A(g490), .Y(n5132));
INVX1    g0510(.A(g528), .Y(n5142));
INVX1    g0498(.A(g482), .Y(n5130_1));
INVX1    g2653(.A(g203), .Y(n7298_1));
INVX1    g0497(.A(g518), .Y(n5129));
INVX1    g0960(.A(g385), .Y(n5600));
INVX1    g0958(.A(g358), .Y(n5598));
INVX1    g0959(.A(g376), .Y(n5599));

endmodule
