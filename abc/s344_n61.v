//Converted to Combinational (Partial output: n61) , Module name: s344_n61
module s344_n61 ( START, ACVQN2, CT1, CT2, CT0, AX3, MRVQN0, ACVQN3, AX2, AX1, AX0, ACVQN1, ACVQN0, n61 );
input START, ACVQN2, CT1, CT2, CT0, AX3, MRVQN0, ACVQN3, AX2, AX1, AX0, ACVQN1, ACVQN0;
output n61;
wire n82, n103, n87, n102, P6, READY, n86_1, n95, n97, n101_1, n98, n73, n75, n94, n91_1, n93, P7, P0, n96_1, n92, n90, n88, n89, P5, P4;
NAND2X1  g39(.A(n103), .B(n82), .Y(n61));
INVX1    g17(.A(START), .Y(n82));
MX2X1    g38(.A(P6), .B(n102), .S0(n87), .Y(n103));
NOR2X1   g22(.A(n86_1), .B(READY), .Y(n87));
OAI22X1  g37(.A0(n98), .A1(n101_1), .B0(n97), .B1(n95), .Y(n102));
INVX1    g02(.A(ACVQN2), .Y(P6));
NOR3X1   g13(.A(n75), .B(CT1), .C(n73), .Y(READY));
NOR3X1   g21(.A(CT0), .B(CT1), .C(CT2), .Y(n86_1));
AOI21X1  g30(.A0(n93), .A1(n91_1), .B0(n94), .Y(n95));
NAND3X1  g32(.A(AX3), .B(P0), .C(P7), .Y(n97));
AND2X1   g36(.A(n96_1), .B(n95), .Y(n101_1));
OAI21X1  g33(.A0(n96_1), .A1(n95), .B0(n97), .Y(n98));
INVX1    g08(.A(CT2), .Y(n73));
INVX1    g10(.A(CT0), .Y(n75));
NOR3X1   g29(.A(n92), .B(MRVQN0), .C(ACVQN2), .Y(n94));
OAI21X1  g26(.A0(n89), .A1(n88), .B0(n90), .Y(n91_1));
OAI21X1  g28(.A0(n92), .A1(MRVQN0), .B0(ACVQN2), .Y(n93));
INVX1    g03(.A(ACVQN3), .Y(P7));
INVX1    g04(.A(MRVQN0), .Y(P0));
AOI21X1  g31(.A0(AX3), .A1(P0), .B0(P7), .Y(n96_1));
INVX1    g27(.A(AX2), .Y(n92));
NAND3X1  g25(.A(AX1), .B(P0), .C(P5), .Y(n90));
NAND3X1  g23(.A(AX0), .B(P0), .C(P4), .Y(n88));
AOI21X1  g24(.A0(AX1), .A1(P0), .B0(P5), .Y(n89));
INVX1    g01(.A(ACVQN1), .Y(P5));
INVX1    g00(.A(ACVQN0), .Y(P4));
endmodule
