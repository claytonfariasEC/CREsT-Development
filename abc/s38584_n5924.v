//Converted to Combinational (Partial output: n5924) , Module name: s38584_n5924 , Timestamp: 2018-12-03T15:51:17.726153 
module s38584_n5924 ( g35, g5467, g5462, g4674, g4801, g4793, g4709, g4776, g4653, g4669, g4659, g4743, g4785, g5644, g5630, g5689, g5703, g5615, g5623, g5659, g5563, g5567, g5685, g5607, g5637, g5575, g5559, g5547, g5579, g5673, g5555, g5654, g5587, g5571, g5681, g5603, g5543, g5677, g5595, g5611, g5551, g5619, g5583, g5599, g5666, g5591, n5924 );
input g35, g5467, g5462, g4674, g4801, g4793, g4709, g4776, g4653, g4669, g4659, g4743, g4785, g5644, g5630, g5689, g5703, g5615, g5623, g5659, g5563, g5567, g5685, g5607, g5637, g5575, g5559, g5547, g5579, g5673, g5555, g5654, g5587, g5571, g5681, g5603, g5543, g5677, g5595, g5611, g5551, g5619, g5583, g5599, g5666, g5591;
output n5924;
wire n9886, n7016, n9885, n7014, n4721, n7015, n9883, n9884, n4720, n4723, n4817_1, n4818, n9882, n9851, n9865, n9872, n9701, n9874, n9877, n9881, n9847, n9850, n9858, n9861, n9864, n9871, n9866, n9868, n9873, n9875, n7020, n9876, n9878, n9879, n9880, n7027_1, n9845, n9846, n9848, n9849, n9857, n9853, n9854, n9855, n9859, n9860, n9862, n9863, n9869, n9870, n5871, n5194, n9867, n7019, n9844, n7022_1, n7026, n9856, n9852;
MX2X1    g5238(.A(g5467), .B(n9886), .S0(g35), .Y(n5924));
MX2X1    g5237(.A(g5462), .B(n9885), .S0(n7016), .Y(n9886));
AOI21X1  g2372(.A0(n7015), .A1(n4721), .B0(n7014), .Y(n7016));
XOR2X1   g5236(.A(n9884), .B(n9883), .Y(n9885));
INVX1    g2370(.A(g4674), .Y(n7014));
NOR3X1   g0101(.A(g4793), .B(g4801), .C(n4720), .Y(n4721));
NOR4X1   g2371(.A(n4818), .B(g4709), .C(n4817_1), .D(n4723), .Y(n7015));
NAND4X1  g5234(.A(n9872), .B(n9865), .C(n9851), .D(n9882), .Y(n9883));
AND2X1   g5235(.A(n9701), .B(g5462), .Y(n9884));
INVX1    g0100(.A(g4776), .Y(n4720));
NAND3X1  g0103(.A(g4659), .B(g4669), .C(g4653), .Y(n4723));
INVX1    g0197(.A(g4743), .Y(n4817_1));
INVX1    g0198(.A(g4785), .Y(n4818));
NOR3X1   g5233(.A(n9881), .B(n9877), .C(n9874), .Y(n9882));
NOR2X1   g5202(.A(n9850), .B(n9847), .Y(n9851));
NOR3X1   g5216(.A(n9864), .B(n9861), .C(n9858), .Y(n9865));
AOI21X1  g5223(.A0(n9868), .A1(n9866), .B0(n9871), .Y(n9872));
NAND4X1  g5052(.A(g5703), .B(g5689), .C(g5630), .D(g5644), .Y(n9701));
NOR2X1   g5225(.A(n9873), .B(n9866), .Y(n9874));
OAI21X1  g5228(.A0(n9876), .A1(n7020), .B0(n9875), .Y(n9877));
AOI21X1  g5232(.A0(n9880), .A1(n9879), .B0(n9878), .Y(n9881));
AOI21X1  g5198(.A0(n9846), .A1(n9845), .B0(n7027_1), .Y(n9847));
OAI21X1  g5201(.A0(n9849), .A1(n7020), .B0(n9848), .Y(n9850));
NAND4X1  g5209(.A(n9855), .B(n9854), .C(n9853), .D(n9857), .Y(n9858));
OAI21X1  g5212(.A0(n9860), .A1(n7027_1), .B0(n9859), .Y(n9861));
NAND2X1  g5215(.A(n9863), .B(n9862), .Y(n9864));
AOI21X1  g5222(.A0(n9870), .A1(n9869), .B0(n9866), .Y(n9871));
XOR2X1   g5217(.A(g5689), .B(n5871), .Y(n9866));
AND2X1   g5219(.A(n9867), .B(n5194), .Y(n9868));
NAND4X1  g5224(.A(n7019), .B(g5623), .C(g5615), .D(g5644), .Y(n9873));
NAND4X1  g5226(.A(g5563), .B(n9844), .C(g5659), .D(n5194), .Y(n9875));
NAND2X1  g2376(.A(g5644), .B(n7019), .Y(n7020));
NAND3X1  g5227(.A(g5685), .B(n9844), .C(g5567), .Y(n9876));
INVX1    g5229(.A(n9866), .Y(n9878));
NAND3X1  g5230(.A(n7022_1), .B(g5623), .C(g5607), .Y(n9879));
NAND4X1  g5231(.A(g5644), .B(n7019), .C(g5575), .D(g5637), .Y(n9880));
NAND2X1  g2383(.A(n7026), .B(g5703), .Y(n7027_1));
NAND3X1  g5196(.A(n9844), .B(g5630), .C(g5559), .Y(n9845));
NAND3X1  g5197(.A(g5547), .B(g5689), .C(g5659), .Y(n9846));
NAND4X1  g5199(.A(g5673), .B(n9844), .C(g5579), .D(n5194), .Y(n9848));
NAND3X1  g5200(.A(g5654), .B(n9844), .C(g5555), .Y(n9849));
NAND4X1  g5208(.A(g5644), .B(n7019), .C(g5587), .D(n9856), .Y(n9857));
NAND4X1  g5204(.A(n7026), .B(g5703), .C(g5571), .D(n9852), .Y(n9853));
NAND4X1  g5205(.A(g5603), .B(g5681), .C(g5689), .D(n5194), .Y(n9854));
NAND4X1  g5206(.A(g5654), .B(g5689), .C(g5543), .D(n7022_1), .Y(n9855));
NAND4X1  g5210(.A(g5595), .B(g5677), .C(n9844), .D(n7022_1), .Y(n9859));
NAND3X1  g5211(.A(g5681), .B(n9844), .C(g5611), .Y(n9860));
NAND4X1  g5213(.A(g5685), .B(g5689), .C(g5551), .D(n7022_1), .Y(n9862));
NAND4X1  g5214(.A(g5619), .B(g5689), .C(g5630), .D(n5194), .Y(n9863));
NAND3X1  g5220(.A(n7022_1), .B(g5637), .C(g5583), .Y(n9869));
NAND4X1  g5221(.A(n7026), .B(g5703), .C(g5666), .D(g5599), .Y(n9870));
INVX1    g1231(.A(g5659), .Y(n5871));
AND2X1   g0561(.A(g5644), .B(g5703), .Y(n5194));
AND2X1   g5218(.A(g5666), .B(g5591), .Y(n9867));
INVX1    g2375(.A(g5703), .Y(n7019));
INVX1    g5195(.A(g5689), .Y(n9844));
NOR2X1   g2378(.A(g5644), .B(g5703), .Y(n7022_1));
INVX1    g2382(.A(g5644), .Y(n7026));
AND2X1   g5207(.A(g5677), .B(g5689), .Y(n9856));
AND2X1   g5203(.A(g5673), .B(g5689), .Y(n9852));

endmodule
