//Converted to Combinational (Partial output: n95) , Module name: s820_n95
module s820_n95 ( G4, G1, G18, G16, G38, G39, G40, G0, G41, G42, G15, G13, G7, G8, G2, G5, G9, G6, G14, n95 );
input G3, G4, G1, G18, G16, G38, G39, G40, G0, G41, G42, G15, G13, G7, G8, G2, G5, G9, G6, G14;
output n95;
wire n234, n245, n223, n233, n119, n242, n244, n222, n53, n219, n226, n73, n232, n117, n118, n238, n241, n243, n77, n201, n212, n220, n221, n218, n156, n217, n225, n113, n224, n231, n227, n230, n116, n58, n236, n237, n240, n82, n239, n95_1, n107, n56, n54, n52, n229, n228, n235, n76, n175, n104, n136, n83;
AOI21X1  g194(.A0(n245), .A1(n234), .B0(G18), .Y(n95));
OAI21X1  g182(.A0(n233), .A1(n223), .B0(G16), .Y(n234));
NOR3X1   g193(.A(n244), .B(n242), .C(n119), .Y(n245));
AOI21X1  g171(.A0(n219), .A1(n53), .B0(n222), .Y(n223));
OAI21X1  g181(.A0(n232), .A1(n73), .B0(n226), .Y(n233));
NOR2X1   g067(.A(n118), .B(n117), .Y(n119));
AOI21X1  g190(.A0(n241), .A1(n238), .B0(G38), .Y(n242));
NOR4X1   g192(.A(n212), .B(n201), .C(n77), .D(n243), .Y(n244));
OR2X1    g170(.A(n221), .B(n220), .Y(n222));
INVX1    g001(.A(G39), .Y(n53));
NAND4X1  g167(.A(n217), .B(n156), .C(G40), .D(n218), .Y(n219));
NAND4X1  g174(.A(n224), .B(n218), .C(n113), .D(n225), .Y(n226));
OR2X1    g021(.A(G39), .B(G38), .Y(n73));
AOI21X1  g180(.A0(n230), .A1(n227), .B0(n231), .Y(n232));
AOI21X1  g065(.A0(n116), .A1(G38), .B0(n113), .Y(n117));
NAND2X1  g066(.A(G39), .B(G4), .Y(n118));
OAI21X1  g186(.A0(n237), .A1(n236), .B0(n58), .Y(n238));
AOI21X1  g189(.A0(n239), .A1(n82), .B0(n240), .Y(n241));
AND2X1   g191(.A(G39), .B(G0), .Y(n243));
INVX1    g025(.A(G38), .Y(n77));
NAND3X1  g149(.A(G42), .B(G41), .C(G40), .Y(n201));
NOR2X1   g160(.A(G39), .B(G4), .Y(n212));
AOI21X1  g168(.A0(n107), .A1(n113), .B0(n95_1), .Y(n220));
OAI21X1  g169(.A0(G40), .A1(G15), .B0(G41), .Y(n221));
OR2X1    g166(.A(G42), .B(G15), .Y(n218));
NAND2X1  g104(.A(n56), .B(G38), .Y(n156));
NAND3X1  g165(.A(G42), .B(G15), .C(G13), .Y(n217));
OAI21X1  g173(.A0(n56), .A1(G41), .B0(n53), .Y(n225));
INVX1    g061(.A(G40), .Y(n113));
NAND3X1  g172(.A(G42), .B(G39), .C(G15), .Y(n224));
OAI22X1  g179(.A0(n56), .A1(G15), .B0(G1), .B1(n54), .Y(n231));
NOR3X1   g175(.A(G42), .B(n113), .C(n52), .Y(n227));
NOR4X1   g178(.A(G8), .B(G7), .C(n228), .D(n229), .Y(n230));
NOR2X1   g064(.A(G42), .B(G41), .Y(n116));
AND2X1   g006(.A(G40), .B(G39), .Y(n58));
NOR4X1   g184(.A(n56), .B(G41), .C(G2), .D(n235), .Y(n236));
AOI21X1  g185(.A0(n76), .A1(G5), .B0(G42), .Y(n237));
NOR4X1   g188(.A(n136), .B(G39), .C(n104), .D(n175), .Y(n240));
NOR3X1   g030(.A(G42), .B(n76), .C(G40), .Y(n82));
NOR3X1   g187(.A(G39), .B(n52), .C(n83), .Y(n239));
NAND2X1  g043(.A(G39), .B(G38), .Y(n95_1));
NAND4X1  g055(.A(G8), .B(G7), .C(G6), .D(G9), .Y(n107));
INVX1    g004(.A(G42), .Y(n56));
OR2X1    g002(.A(G41), .B(G40), .Y(n54));
INVX1    g000(.A(G15), .Y(n52));
INVX1    g177(.A(G9), .Y(n229));
INVX1    g176(.A(G6), .Y(n228));
OR2X1    g183(.A(G3), .B(G1), .Y(n235));
INVX1    g024(.A(G41), .Y(n76));
NOR2X1   g123(.A(G42), .B(G40), .Y(n175));
INVX1    g052(.A(G4), .Y(n104));
NOR2X1   g084(.A(G41), .B(G40), .Y(n136));
INVX1    g031(.A(G14), .Y(n83));

endmodule
