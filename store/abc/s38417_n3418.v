//Converted to Combinational (Partial output: n3418) , Module name: s38417_n3418 , Timestamp: 2018-12-03T15:51:13.608594 
module s38417_n3418 ( g1090, g963, g996, g1089, g1091, g869, g1088, g1092, g809, g857, g856, g858, g801, g797, g805, g785, g813, g845, g844, g846, g793, g789, g842, g841, g843, g860, g859, g861, g851, g850, g852, g826, g853, g823, g863, g862, g864, g848, g847, g849, g836, g835, g837, g833, g832, g834, g839, g838, g840, g818, g817, g819, g830, g829, g831, g821, g820, g822, n3418 );
input g1090, g963, g996, g1089, g1091, g869, g1088, g1092, g809, g857, g856, g858, g801, g797, g805, g785, g813, g845, g844, g846, g793, g789, g842, g841, g843, g860, g859, g861, g851, g850, g852, g826, g853, g823, g863, g862, g864, g848, g847, g849, g836, g835, g837, g833, g832, g834, g839, g838, g840, g818, g817, g819, g830, g829, g831, g821, g820, g822;
output n3418;
wire n6934, n6933, n6583_1, n6451, n6468, n6482, n6581, n6582, n6450, n6439_1, n6442, n6446, n6467, n6455, n6459_1, n6463, n6481, n6469_1, n6473, n6477, n6559_1, n6562, n6561, n3442, n6449_1, n6412, n6438, n6440, n6441, n6406, n6445, n6466, n3460, n6454_1, n3469, n6458, n3451, n6462, n3496, n6480, n3433, n6464_1, n6465, n3478, n6472, n3487, n6476, n6447, n6448, n6410, n6411, n6436, n6437, n6401, n6404_1, n6403, n6402, n6405, n6443, n6444_1, n6452, n6453, n6456, n6457, n6460, n6461, n6478, n6479_1, n6470, n6471, n6474_1, n6475;
MX2X1    g1891(.A(g1090), .B(n6933), .S0(n6934), .Y(n3418));
AND2X1   g1890(.A(g996), .B(g963), .Y(n6934));
NAND4X1  g1889(.A(n6482), .B(n6468), .C(n6451), .D(n6583_1), .Y(n6933));
NOR2X1   g1540(.A(n6582), .B(n6581), .Y(n6583_1));
NOR4X1   g1408(.A(n6446), .B(n6442), .C(n6439_1), .D(n6450), .Y(n6451));
NOR4X1   g1425(.A(n6463), .B(n6459_1), .C(n6455), .D(n6467), .Y(n6468));
NOR4X1   g1439(.A(n6477), .B(n6473), .C(n6469_1), .D(n6481), .Y(n6482));
NOR2X1   g1538(.A(g1090), .B(n6559_1), .Y(n6581));
OAI22X1  g1539(.A0(g1091), .A1(n6561), .B0(n6562), .B1(g1089), .Y(n6582));
XOR2X1   g1407(.A(n6449_1), .B(n3442), .Y(n6450));
AND2X1   g1396(.A(n6438), .B(n6412), .Y(n6439_1));
OAI21X1  g1399(.A0(n6441), .A1(n6440), .B0(g869), .Y(n6442));
XOR2X1   g1403(.A(n6445), .B(n6406), .Y(n6446));
OAI21X1  g1424(.A0(n6438), .A1(n6412), .B0(n6466), .Y(n6467));
XOR2X1   g1412(.A(n6454_1), .B(n3460), .Y(n6455));
XOR2X1   g1416(.A(n6458), .B(n3469), .Y(n6459_1));
XOR2X1   g1420(.A(n6462), .B(n3451), .Y(n6463));
XOR2X1   g1438(.A(n6480), .B(n3496), .Y(n6481));
NOR3X1   g1426(.A(n6465), .B(n6464_1), .C(n3433), .Y(n6469_1));
XOR2X1   g1430(.A(n6472), .B(n3478), .Y(n6473));
XOR2X1   g1434(.A(n6476), .B(n3487), .Y(n6477));
INVX1    g1516(.A(g963), .Y(n6559_1));
INVX1    g1519(.A(g1088), .Y(n6562));
INVX1    g1518(.A(g1092), .Y(n6561));
INVX1    g1350(.A(g809), .Y(n3442));
NOR2X1   g1406(.A(n6448), .B(n6447), .Y(n6449_1));
NOR2X1   g1369(.A(n6411), .B(n6410), .Y(n6412));
OR2X1    g1395(.A(n6437), .B(n6436), .Y(n6438));
NOR2X1   g1397(.A(g857), .B(n6401), .Y(n6440));
OAI22X1  g1398(.A0(g858), .A1(n6403), .B0(n6404_1), .B1(g856), .Y(n6441));
NOR2X1   g1363(.A(n6405), .B(n6402), .Y(n6406));
NOR2X1   g1402(.A(n6444_1), .B(n6443), .Y(n6445));
OAI21X1  g1423(.A0(n6465), .A1(n6464_1), .B0(n3433), .Y(n6466));
INVX1    g1342(.A(g801), .Y(n3460));
NOR2X1   g1411(.A(n6453), .B(n6452), .Y(n6454_1));
INVX1    g1338(.A(g797), .Y(n3469));
NOR2X1   g1415(.A(n6457), .B(n6456), .Y(n6458));
INVX1    g1346(.A(g805), .Y(n3451));
NOR2X1   g1419(.A(n6461), .B(n6460), .Y(n6462));
INVX1    g1323(.A(g785), .Y(n3496));
NOR2X1   g1437(.A(n6479_1), .B(n6478), .Y(n6480));
INVX1    g1354(.A(g813), .Y(n3433));
NOR2X1   g1421(.A(g845), .B(n6401), .Y(n6464_1));
OAI22X1  g1422(.A0(g846), .A1(n6403), .B0(n6404_1), .B1(g844), .Y(n6465));
INVX1    g1334(.A(g793), .Y(n3478));
NOR2X1   g1429(.A(n6471), .B(n6470), .Y(n6472));
INVX1    g1330(.A(g789), .Y(n3487));
NOR2X1   g1433(.A(n6475), .B(n6474_1), .Y(n6476));
NOR2X1   g1404(.A(g842), .B(n6401), .Y(n6447));
OAI22X1  g1405(.A0(g843), .A1(n6403), .B0(n6404_1), .B1(g841), .Y(n6448));
NOR2X1   g1367(.A(g860), .B(n6401), .Y(n6410));
OAI22X1  g1368(.A0(g861), .A1(n6403), .B0(n6404_1), .B1(g859), .Y(n6411));
NOR2X1   g1393(.A(g851), .B(n6401), .Y(n6436));
OAI22X1  g1394(.A0(g852), .A1(n6403), .B0(n6404_1), .B1(g850), .Y(n6437));
INVX1    g1358(.A(g826), .Y(n6401));
INVX1    g1361(.A(g853), .Y(n6404_1));
INVX1    g1360(.A(g823), .Y(n6403));
NOR2X1   g1359(.A(g863), .B(n6401), .Y(n6402));
OAI22X1  g1362(.A0(g864), .A1(n6403), .B0(n6404_1), .B1(g862), .Y(n6405));
NOR2X1   g1400(.A(g848), .B(n6401), .Y(n6443));
OAI22X1  g1401(.A0(g849), .A1(n6403), .B0(n6404_1), .B1(g847), .Y(n6444_1));
NOR2X1   g1409(.A(g836), .B(n6401), .Y(n6452));
OAI22X1  g1410(.A0(g837), .A1(n6403), .B0(n6404_1), .B1(g835), .Y(n6453));
NOR2X1   g1413(.A(g833), .B(n6401), .Y(n6456));
OAI22X1  g1414(.A0(g834), .A1(n6403), .B0(n6404_1), .B1(g832), .Y(n6457));
NOR2X1   g1417(.A(g839), .B(n6401), .Y(n6460));
OAI22X1  g1418(.A0(g840), .A1(n6403), .B0(n6404_1), .B1(g838), .Y(n6461));
NOR2X1   g1435(.A(g818), .B(n6401), .Y(n6478));
OAI22X1  g1436(.A0(g819), .A1(n6403), .B0(n6404_1), .B1(g817), .Y(n6479_1));
NOR2X1   g1427(.A(g830), .B(n6401), .Y(n6470));
OAI22X1  g1428(.A0(g831), .A1(n6403), .B0(n6404_1), .B1(g829), .Y(n6471));
NOR2X1   g1431(.A(g821), .B(n6401), .Y(n6474_1));
OAI22X1  g1432(.A0(g822), .A1(n6403), .B0(n6404_1), .B1(g820), .Y(n6475));

endmodule
