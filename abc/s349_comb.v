//Converted to Combinational , Module name: s349 , Timestamp: 2018-12-03T15:51:01.431035 
module s349 ( START, B0, B1, B2, B3, A0, A1, A2, A3, CT2, CT1, CT0, ACVQN3, ACVQN2, ACVQN1, ACVQN0, MRVQN3, MRVQN2, MRVQN1, MRVQN0, AX3, AX2, AX1, AX0, CNTVCO2, CNTVCON2, READY, P0, P1, P2, P3, P4, P5, P6, P7, n41, n46, n51, n56, n61, n66, n71, n76, n81, n86, n91, n96, n101, n106, n111 );
input START, B0, B1, B2, B3, A0, A1, A2, A3, CT2, CT1, CT0, ACVQN3, ACVQN2, ACVQN1, ACVQN0, MRVQN3, MRVQN2, MRVQN1, MRVQN0, AX3, AX2, AX1, AX0;
output CNTVCO2, CNTVCON2, READY, P0, P1, P2, P3, P4, P5, P6, P7, n41, n46, n51, n56, n61, n66, n71, n76, n81, n86, n91, n96, n101, n106, n111;
wire n65, n66_1, n67, n79, n80, n82, n83, n84, n88, n89, n90, n91_1, n92, n93, n94, n95, n96_1, n97, n98, n99, n100, n101_1, n103, n104, n105, n107, n108, n109, n110, n111_1, n112, n113, n114, n115, n116, n117, n118, n120, n121, n122, n124, n125, n126, n127, n129, n130, n132, n133, n135, n136;
INVX1    g00(.A(CT2), .Y(n65));
INVX1    g01(.A(CT1), .Y(n66_1));
INVX1    g02(.A(CT0), .Y(n67));
NOR3X1   g03(.A(n67), .B(n66_1), .C(n65), .Y(CNTVCO2));
INVX1    g04(.A(CNTVCO2), .Y(CNTVCON2));
NOR3X1   g05(.A(n67), .B(CT1), .C(n65), .Y(READY));
INVX1    g06(.A(MRVQN0), .Y(P0));
INVX1    g07(.A(MRVQN1), .Y(P1));
INVX1    g08(.A(MRVQN2), .Y(P2));
INVX1    g09(.A(MRVQN3), .Y(P3));
INVX1    g10(.A(ACVQN0), .Y(P4));
INVX1    g11(.A(ACVQN1), .Y(P5));
INVX1    g12(.A(ACVQN2), .Y(P6));
INVX1    g13(.A(ACVQN3), .Y(P7));
AOI21X1  g14(.A0(CT0), .A1(CT1), .B0(CT2), .Y(n79));
NOR3X1   g15(.A(n67), .B(n66_1), .C(n65), .Y(n80));
NOR3X1   g16(.A(n80), .B(n79), .C(START), .Y(n41));
OAI21X1  g17(.A0(CT1), .A1(n65), .B0(CT0), .Y(n82));
INVX1    g18(.A(START), .Y(n83));
OAI21X1  g19(.A0(n82), .A1(n66_1), .B0(n83), .Y(n84));
AOI21X1  g20(.A0(n82), .A1(n66_1), .B0(n84), .Y(n46));
AND2X1   g21(.A(n83), .B(n82), .Y(n51));
NOR3X1   g22(.A(CT0), .B(CT1), .C(CT2), .Y(n88));
NOR2X1   g23(.A(n88), .B(READY), .Y(n89));
NAND3X1  g24(.A(AX0), .B(P0), .C(P4), .Y(n90));
AOI21X1  g25(.A0(AX1), .A1(P0), .B0(P5), .Y(n91_1));
NAND3X1  g26(.A(AX1), .B(P0), .C(P5), .Y(n92));
OAI21X1  g27(.A0(n91_1), .A1(n90), .B0(n92), .Y(n93));
INVX1    g28(.A(AX2), .Y(n94));
OAI21X1  g29(.A0(n94), .A1(MRVQN0), .B0(ACVQN2), .Y(n95));
NOR3X1   g30(.A(n94), .B(MRVQN0), .C(ACVQN2), .Y(n96_1));
AOI21X1  g31(.A0(n95), .A1(n93), .B0(n96_1), .Y(n97));
AOI21X1  g32(.A0(AX3), .A1(P0), .B0(P7), .Y(n98));
NAND3X1  g33(.A(AX3), .B(P0), .C(P7), .Y(n99));
OAI21X1  g34(.A0(n98), .A1(n97), .B0(n99), .Y(n100));
MX2X1    g35(.A(P7), .B(n100), .S0(n89), .Y(n101_1));
NAND2X1  g36(.A(n101_1), .B(n83), .Y(n56));
AND2X1   g37(.A(n98), .B(n97), .Y(n103));
OAI22X1  g38(.A0(n100), .A1(n103), .B0(n99), .B1(n97), .Y(n104));
MX2X1    g39(.A(P6), .B(n104), .S0(n89), .Y(n105));
NAND2X1  g40(.A(n105), .B(n83), .Y(n61));
INVX1    g41(.A(AX0), .Y(n107));
NOR3X1   g42(.A(n107), .B(MRVQN0), .C(ACVQN0), .Y(n108));
INVX1    g43(.A(AX1), .Y(n109));
OAI21X1  g44(.A0(n109), .A1(MRVQN0), .B0(ACVQN1), .Y(n110));
NOR3X1   g45(.A(n109), .B(MRVQN0), .C(ACVQN1), .Y(n111_1));
AOI21X1  g46(.A0(n110), .A1(n108), .B0(n111_1), .Y(n112));
INVX1    g47(.A(n96_1), .Y(n113));
INVX1    g48(.A(n95), .Y(n114));
OAI21X1  g49(.A0(n114), .A1(n112), .B0(n113), .Y(n115));
NOR2X1   g50(.A(n95), .B(n93), .Y(n116));
OAI22X1  g51(.A0(n115), .A1(n116), .B0(n113), .B1(n112), .Y(n117));
MX2X1    g52(.A(P5), .B(n117), .S0(n89), .Y(n118));
NAND2X1  g53(.A(n118), .B(n83), .Y(n66));
NOR2X1   g54(.A(n110), .B(n108), .Y(n120));
OAI22X1  g55(.A0(n93), .A1(n120), .B0(n92), .B1(n90), .Y(n121));
MX2X1    g56(.A(P4), .B(n121), .S0(n89), .Y(n122));
NAND2X1  g57(.A(n122), .B(n83), .Y(n71));
INVX1    g58(.A(B3), .Y(n124));
MX2X1    g59(.A(n124), .B(MRVQN3), .S0(READY), .Y(n125));
NOR2X1   g60(.A(n107), .B(MRVQN0), .Y(n126));
XOR2X1   g61(.A(n126), .B(ACVQN0), .Y(n127));
MX2X1    g62(.A(n125), .B(n127), .S0(n89), .Y(n76));
INVX1    g63(.A(B2), .Y(n129));
MX2X1    g64(.A(n129), .B(MRVQN2), .S0(READY), .Y(n130));
MX2X1    g65(.A(n130), .B(MRVQN3), .S0(n89), .Y(n81));
INVX1    g66(.A(B1), .Y(n132));
MX2X1    g67(.A(n132), .B(MRVQN1), .S0(READY), .Y(n133));
MX2X1    g68(.A(n133), .B(MRVQN2), .S0(n89), .Y(n86));
INVX1    g69(.A(B0), .Y(n135));
MX2X1    g70(.A(n135), .B(MRVQN0), .S0(READY), .Y(n136));
MX2X1    g71(.A(n136), .B(MRVQN1), .S0(n89), .Y(n91));
MX2X1    g72(.A(AX3), .B(A3), .S0(n88), .Y(n96));
MX2X1    g73(.A(AX2), .B(A2), .S0(n88), .Y(n101));
MX2X1    g74(.A(AX1), .B(A1), .S0(n88), .Y(n106));
MX2X1    g75(.A(AX0), .B(A0), .S0(n88), .Y(n111));
endmodule
