//Benchmark atmr_9sym4

module atmr_9sym4(i0, i1, i2, i3, i4, i5, i6, i7, i8, z0);
 input i0, i1, i2, i3, i4, i5, i6, i7, i8;
 output z0;
 wire ori_n11_, ori_n12_, ori_n13_, ori_n14_, ori_n15_, ori_n16_, ori_n17_, ori_n18_, ori_n19_, ori_n20_, ori_n21_, ori_n22_, ori_n23_, ori_n24_, ori_n25_, ori_n26_, ori_n27_, ori_n28_, ori_n29_, ori_n30_, ori_n31_, ori_n32_, ori_n33_, ori_n34_, ori_n35_, ori_n36_, ori_n37_, ori_n38_, ori_n39_, ori_n40_, ori_n41_, ori_n42_, ori_n43_, ori_n44_, ori_n45_, ori_n46_, ori_n47_, ori_n48_, ori_n49_, ori_n50_, ori_n51_, ori_n52_, ori_n53_, ori_n54_, ori_n55_, ori_n56_, ori_n57_, ori_n58_, ori_n59_, ori_n60_, ori_n61_, ori_n62_, ori_n63_, ori_n64_, ori_n65_, ori_n66_, ori_n67_, ori_n68_, ori_n69_, ori_n70_, ori_n71_, ori_n72_, ori_n73_, ori_n74_, ori_n75_, ori_n76_, ori_n77_, ori_n78_, ori_n79_, ori_n80_, ori_n81_, ori_n82_, ori_n83_, ori_n84_, ori_n85_, ori_n86_, ori_n87_, ori_n88_, ori_n89_, ori_n90_, ori_n91_, ori_n92_, ori_n93_, ori_n94_, ori_n95_, ori_n96_, ori_n97_, ori_n98_, ori_n99_, ori_n100_, ori_n101_, ori_n102_, ori_n103_, ori_n104_, ori_n105_, ori_n106_, ori_n107_, ori_n108_, ori_n109_, ori_n110_, ori_n111_, ori_n112_, ori_n113_, ori_n114_, ori_n115_, ori_n116_, ori_n117_, ori_n118_, ori_n119_, ori_n120_, ori_n121_, ori_n122_, ori_n123_, ori_n124_, ori_n125_, ori_n126_, ori_n127_, ori_n128_, ori_n129_, ori_n130_, ori_n131_, ori_n132_, ori_n133_, ori_n134_, ori_n135_, ori_n136_, ori_n137_, ori_n138_, ori_n139_, ori_n140_, ori_n141_, ori_n142_, ori_n143_, ori_n144_, ori_n145_, ori_n146_, ori_n147_, ori_n148_, ori_n149_, ori_n150_, mai_n11_, mai_n12_, mai_n13_, mai_n14_, mai_n15_, mai_n16_, mai_n17_, mai_n18_, mai_n19_, mai_n20_, mai_n21_, mai_n22_, mai_n23_, mai_n24_, mai_n25_, mai_n26_, mai_n27_, mai_n28_, mai_n29_, mai_n30_, mai_n31_, mai_n32_, mai_n33_, mai_n34_, mai_n35_, mai_n36_, mai_n37_, mai_n38_, mai_n39_, mai_n40_, mai_n41_, mai_n42_, mai_n43_, mai_n44_, mai_n45_, mai_n46_, mai_n47_, mai_n48_, mai_n49_, mai_n50_, mai_n51_, mai_n52_, mai_n53_, mai_n54_, mai_n55_, mai_n56_, mai_n57_, mai_n58_, mai_n59_, mai_n60_, mai_n61_, mai_n62_, mai_n63_, mai_n64_, mai_n65_, mai_n66_, mai_n67_, mai_n68_, mai_n69_, mai_n70_, mai_n71_, mai_n72_, mai_n73_, mai_n74_, mai_n75_, mai_n76_, mai_n77_, mai_n78_, mai_n79_, mai_n80_, mai_n81_, mai_n82_, mai_n83_, mai_n84_, mai_n85_, mai_n86_, mai_n87_, mai_n88_, mai_n89_, mai_n90_, mai_n91_, mai_n92_, mai_n93_, mai_n94_, mai_n95_, mai_n96_, mai_n97_, mai_n98_, mai_n99_, mai_n100_, mai_n101_, mai_n102_, mai_n103_, mai_n104_, mai_n105_, mai_n106_, mai_n107_, mai_n108_, mai_n109_, mai_n110_, mai_n111_, mai_n112_, mai_n113_, mai_n114_, mai_n115_, mai_n116_, mai_n117_, mai_n118_, mai_n119_, mai_n120_, mai_n121_, mai_n122_, mai_n123_, mai_n124_, mai_n125_, mai_n126_, mai_n127_, mai_n128_, mai_n129_, mai_n130_, mai_n131_, mai_n132_, mai_n133_, mai_n134_, mai_n135_, mai_n136_, mai_n137_, mai_n138_, mai_n139_, mai_n140_, mai_n141_, mai_n142_, mai_n143_, mai_n144_, mai_n145_, mai_n146_, mai_n147_, mai_n148_, mai_n149_, mai_n150_, men_n11_, men_n12_, men_n13_, men_n14_, men_n15_, men_n16_, men_n17_, men_n18_, men_n19_, men_n20_, men_n21_, men_n22_, men_n23_, men_n24_, men_n25_, men_n26_, men_n27_, men_n28_, men_n29_, men_n30_, men_n31_, men_n32_, men_n33_, men_n34_, men_n35_, men_n36_, men_n37_, men_n38_, men_n39_, men_n40_, men_n41_, men_n42_, men_n43_, men_n44_, men_n45_, men_n46_, men_n47_, men_n48_, men_n49_, men_n50_, men_n51_, men_n52_, men_n53_, men_n54_, men_n55_, men_n56_, men_n57_, men_n58_, men_n59_, men_n60_, men_n61_, men_n62_, men_n63_, men_n64_, men_n65_, men_n66_, men_n67_, men_n68_, men_n69_, men_n70_, men_n71_, men_n72_, men_n73_, men_n74_, men_n75_, men_n76_, men_n77_, men_n78_, men_n79_, men_n80_, men_n81_, men_n82_, men_n83_, men_n84_, men_n85_, men_n86_, men_n87_, men_n88_, men_n89_, men_n90_, men_n91_, men_n92_, men_n93_, men_n94_, men_n95_, men_n96_, men_n97_, men_n98_, men_n99_, men_n100_, men_n101_, men_n102_, men_n103_, men_n104_, men_n105_, men_n106_, men_n107_, men_n108_, men_n109_, men_n110_, men_n111_, men_n112_, men_n113_, men_n114_, men_n115_, men_n116_, men_n117_, men_n118_, men_n119_, men_n120_, men_n121_, men_n122_, men_n123_, men_n124_, men_n125_, men_n126_, men_n127_, men_n128_, men_n129_, men_n130_, men_n131_, men_n132_, men_n133_, men_n134_, men_n135_, men_n136_, men_n137_, men_n138_, men_n139_, men_n140_, men_n141_, men_n142_, men_n143_, men_n144_, men_n145_, men_n146_, men_n147_, men_n148_, men_n149_, men_n150_, zori10, zori20, zori30;
  INV        o000(.A(i5), .Y(ori_n11_));
  NO2        o001(.A(ori_n11_), .B(i3), .Y(ori_n12_));
  INV        o002(.A(i7), .Y(ori_n13_));
  NA2        o003(.A(i8), .B(ori_n13_), .Y(ori_n14_));
  NOi21      o004(.An(ori_n14_), .B(ori_n12_), .Y(ori_n15_));
  NO2        o005(.A(ori_n15_), .B(i0), .Y(ori_n16_));
  INV        o006(.A(i3), .Y(ori_n17_));
  INV        o007(.A(i6), .Y(ori_n18_));
  NA2        o008(.A(ori_n18_), .B(ori_n17_), .Y(ori_n19_));
  NO2        o009(.A(ori_n19_), .B(ori_n13_), .Y(ori_n20_));
  OAI210     o010(.A0(ori_n20_), .A1(ori_n16_), .B0(i1), .Y(ori_n21_));
  INV        o011(.A(i0), .Y(ori_n22_));
  INV        o012(.A(i8), .Y(ori_n23_));
  NO2        o013(.A(i7), .B(ori_n17_), .Y(ori_n24_));
  NA2        o014(.A(ori_n24_), .B(ori_n23_), .Y(ori_n25_));
  NO2        o015(.A(ori_n18_), .B(i5), .Y(ori_n26_));
  NA2        o016(.A(ori_n26_), .B(ori_n17_), .Y(ori_n27_));
  AOI210     o017(.A0(ori_n27_), .A1(ori_n25_), .B0(ori_n22_), .Y(ori_n28_));
  NA2        o018(.A(ori_n26_), .B(i8), .Y(ori_n29_));
  NA3        o019(.A(i7), .B(i3), .C(ori_n22_), .Y(ori_n30_));
  AOI210     o020(.A0(ori_n30_), .A1(ori_n29_), .B0(i1), .Y(ori_n31_));
  NO4        o021(.A(ori_n13_), .B(ori_n18_), .C(i5), .D(i0), .Y(ori_n32_));
  NAi21      o022(.An(i6), .B(i5), .Y(ori_n33_));
  NA2        o023(.A(ori_n11_), .B(i1), .Y(ori_n34_));
  NA2        o024(.A(ori_n23_), .B(i3), .Y(ori_n35_));
  AOI210     o025(.A0(ori_n34_), .A1(ori_n33_), .B0(ori_n35_), .Y(ori_n36_));
  NO4        o026(.A(ori_n36_), .B(ori_n32_), .C(ori_n31_), .D(ori_n28_), .Y(ori_n37_));
  AOI210     o027(.A0(ori_n37_), .A1(ori_n21_), .B0(i4), .Y(ori_n38_));
  INV        o028(.A(i1), .Y(ori_n39_));
  NO2        o029(.A(ori_n23_), .B(i3), .Y(ori_n40_));
  INV        o030(.A(i4), .Y(ori_n41_));
  NO2        o031(.A(i6), .B(ori_n41_), .Y(ori_n42_));
  OAI210     o032(.A0(ori_n42_), .A1(ori_n40_), .B0(i0), .Y(ori_n43_));
  NO2        o033(.A(i8), .B(ori_n18_), .Y(ori_n44_));
  NO2        o034(.A(ori_n23_), .B(i0), .Y(ori_n45_));
  OAI210     o035(.A0(ori_n45_), .A1(ori_n44_), .B0(i3), .Y(ori_n46_));
  AOI210     o036(.A0(ori_n46_), .A1(ori_n43_), .B0(i7), .Y(ori_n47_));
  NAi21      o037(.An(i5), .B(i4), .Y(ori_n48_));
  AOI210     o038(.A0(ori_n48_), .A1(ori_n33_), .B0(i0), .Y(ori_n49_));
  AOI210     o039(.A0(ori_n40_), .A1(ori_n11_), .B0(ori_n49_), .Y(ori_n50_));
  NAi21      o040(.An(i6), .B(i7), .Y(ori_n51_));
  NAi21      o041(.An(i8), .B(i5), .Y(ori_n52_));
  OAI220     o042(.A0(ori_n52_), .A1(i3), .B0(ori_n51_), .B1(i5), .Y(ori_n53_));
  NAi21      o043(.An(i6), .B(i8), .Y(ori_n54_));
  OAI210     o044(.A0(ori_n18_), .A1(i0), .B0(ori_n54_), .Y(ori_n55_));
  AOI220     o045(.A0(ori_n55_), .A1(ori_n12_), .B0(ori_n53_), .B1(i0), .Y(ori_n56_));
  OAI210     o046(.A0(ori_n50_), .A1(ori_n13_), .B0(ori_n56_), .Y(ori_n57_));
  OAI210     o047(.A0(ori_n57_), .A1(ori_n47_), .B0(ori_n39_), .Y(ori_n58_));
  NO2        o048(.A(i8), .B(ori_n17_), .Y(ori_n59_));
  AOI220     o049(.A0(ori_n45_), .A1(ori_n13_), .B0(ori_n59_), .B1(ori_n18_), .Y(ori_n60_));
  OAI220     o050(.A0(i7), .A1(ori_n11_), .B0(i6), .B1(ori_n39_), .Y(ori_n61_));
  AOI220     o051(.A0(ori_n61_), .A1(ori_n22_), .B0(ori_n44_), .B1(ori_n13_), .Y(ori_n62_));
  OAI220     o052(.A0(ori_n62_), .A1(i3), .B0(ori_n60_), .B1(i5), .Y(ori_n63_));
  NA2        o053(.A(ori_n23_), .B(i0), .Y(ori_n64_));
  OR2        o054(.A(ori_n64_), .B(ori_n19_), .Y(ori_n65_));
  NO2        o055(.A(ori_n23_), .B(i6), .Y(ori_n66_));
  NO2        o056(.A(i7), .B(i0), .Y(ori_n67_));
  OAI210     o057(.A0(ori_n66_), .A1(ori_n44_), .B0(ori_n67_), .Y(ori_n68_));
  AOI210     o058(.A0(ori_n68_), .A1(ori_n65_), .B0(ori_n39_), .Y(ori_n69_));
  AOI210     o059(.A0(ori_n63_), .A1(i4), .B0(ori_n69_), .Y(ori_n70_));
  NA2        o060(.A(ori_n70_), .B(ori_n58_), .Y(ori_n71_));
  OAI210     o061(.A0(ori_n71_), .A1(ori_n38_), .B0(i2), .Y(ori_n72_));
  AOI210     o062(.A0(ori_n54_), .A1(ori_n35_), .B0(i4), .Y(ori_n73_));
  NO3        o063(.A(i8), .B(ori_n41_), .C(i3), .Y(ori_n74_));
  OAI210     o064(.A0(ori_n74_), .A1(ori_n73_), .B0(i5), .Y(ori_n75_));
  NO2        o065(.A(ori_n17_), .B(i2), .Y(ori_n76_));
  NO2        o066(.A(i8), .B(ori_n13_), .Y(ori_n77_));
  NAi21      o067(.An(ori_n77_), .B(ori_n14_), .Y(ori_n78_));
  NA2        o068(.A(ori_n11_), .B(i3), .Y(ori_n79_));
  INV        o069(.A(i2), .Y(ori_n80_));
  NO2        o070(.A(ori_n13_), .B(i5), .Y(ori_n81_));
  AOI210     o071(.A0(i8), .A1(ori_n80_), .B0(ori_n81_), .Y(ori_n82_));
  OAI220     o072(.A0(ori_n82_), .A1(i3), .B0(ori_n79_), .B1(i6), .Y(ori_n83_));
  AOI220     o073(.A0(ori_n83_), .A1(i4), .B0(ori_n78_), .B1(ori_n76_), .Y(ori_n84_));
  AOI210     o074(.A0(ori_n84_), .A1(ori_n75_), .B0(ori_n39_), .Y(ori_n85_));
  NO2        o075(.A(ori_n11_), .B(i1), .Y(ori_n86_));
  NOi21      o076(.An(ori_n34_), .B(ori_n86_), .Y(ori_n87_));
  AOI220     o077(.A0(ori_n76_), .A1(i8), .B0(ori_n44_), .B1(i4), .Y(ori_n88_));
  NA3        o078(.A(i6), .B(ori_n41_), .C(i3), .Y(ori_n89_));
  OAI210     o079(.A0(ori_n33_), .A1(ori_n41_), .B0(ori_n89_), .Y(ori_n90_));
  NO2        o080(.A(ori_n35_), .B(ori_n33_), .Y(ori_n91_));
  AOI210     o081(.A0(ori_n90_), .A1(ori_n80_), .B0(ori_n91_), .Y(ori_n92_));
  OAI220     o082(.A0(ori_n92_), .A1(ori_n13_), .B0(ori_n88_), .B1(ori_n87_), .Y(ori_n93_));
  OAI210     o083(.A0(ori_n93_), .A1(ori_n85_), .B0(ori_n22_), .Y(ori_n94_));
  NO2        o084(.A(i8), .B(ori_n22_), .Y(ori_n95_));
  OAI210     o085(.A0(ori_n95_), .A1(ori_n26_), .B0(i3), .Y(ori_n96_));
  NO2        o086(.A(i7), .B(i6), .Y(ori_n97_));
  NA2        o087(.A(i7), .B(i6), .Y(ori_n98_));
  NOi21      o088(.An(ori_n98_), .B(ori_n97_), .Y(ori_n99_));
  NA2        o089(.A(ori_n99_), .B(i5), .Y(ori_n100_));
  AO210      o090(.A0(ori_n100_), .A1(ori_n96_), .B0(i4), .Y(ori_n101_));
  NA2        o091(.A(ori_n81_), .B(i8), .Y(ori_n102_));
  OAI210     o092(.A0(ori_n97_), .A1(ori_n64_), .B0(ori_n102_), .Y(ori_n103_));
  AOI220     o093(.A0(ori_n103_), .A1(ori_n17_), .B0(ori_n95_), .B1(ori_n42_), .Y(ori_n104_));
  AOI210     o094(.A0(ori_n104_), .A1(ori_n101_), .B0(ori_n39_), .Y(ori_n105_));
  AOI210     o095(.A0(i7), .A1(ori_n39_), .B0(ori_n40_), .Y(ori_n106_));
  OAI210     o096(.A0(ori_n106_), .A1(i4), .B0(ori_n25_), .Y(ori_n107_));
  NO2        o097(.A(i8), .B(ori_n41_), .Y(ori_n108_));
  AOI220     o098(.A0(ori_n108_), .A1(ori_n39_), .B0(ori_n24_), .B1(ori_n18_), .Y(ori_n109_));
  OAI210     o099(.A0(i7), .A1(ori_n41_), .B0(ori_n51_), .Y(ori_n110_));
  NA2        o100(.A(ori_n110_), .B(ori_n40_), .Y(ori_n111_));
  OAI210     o101(.A0(ori_n109_), .A1(ori_n22_), .B0(ori_n111_), .Y(ori_n112_));
  AOI210     o102(.A0(ori_n107_), .A1(i6), .B0(ori_n112_), .Y(ori_n113_));
  NO3        o103(.A(i6), .B(i5), .C(ori_n17_), .Y(ori_n114_));
  NO3        o104(.A(i8), .B(ori_n18_), .C(i1), .Y(ori_n115_));
  OAI210     o105(.A0(ori_n115_), .A1(ori_n114_), .B0(i4), .Y(ori_n116_));
  NA3        o106(.A(ori_n99_), .B(i8), .C(ori_n39_), .Y(ori_n117_));
  AOI210     o107(.A0(ori_n117_), .A1(ori_n116_), .B0(ori_n22_), .Y(ori_n118_));
  NO2        o108(.A(i5), .B(ori_n41_), .Y(ori_n119_));
  NA2        o109(.A(ori_n119_), .B(ori_n59_), .Y(ori_n120_));
  NA2        o110(.A(i5), .B(i3), .Y(ori_n121_));
  NA4        o111(.A(ori_n121_), .B(ori_n19_), .C(i8), .D(ori_n39_), .Y(ori_n122_));
  AOI210     o112(.A0(ori_n122_), .A1(ori_n120_), .B0(ori_n13_), .Y(ori_n123_));
  NO4        o113(.A(ori_n79_), .B(ori_n23_), .C(i7), .D(ori_n41_), .Y(ori_n124_));
  NO3        o114(.A(ori_n124_), .B(ori_n123_), .C(ori_n118_), .Y(ori_n125_));
  OAI210     o115(.A0(ori_n113_), .A1(ori_n11_), .B0(ori_n125_), .Y(ori_n126_));
  OAI210     o116(.A0(ori_n126_), .A1(ori_n105_), .B0(ori_n80_), .Y(ori_n127_));
  AOI210     o117(.A0(i7), .A1(ori_n17_), .B0(ori_n44_), .Y(ori_n128_));
  OAI220     o118(.A0(ori_n128_), .A1(ori_n11_), .B0(ori_n51_), .B1(ori_n17_), .Y(ori_n129_));
  OAI210     o119(.A0(ori_n42_), .A1(ori_n26_), .B0(ori_n77_), .Y(ori_n130_));
  NO2        o120(.A(ori_n23_), .B(i4), .Y(ori_n131_));
  AOI220     o121(.A0(ori_n131_), .A1(i5), .B0(ori_n26_), .B1(i3), .Y(ori_n132_));
  OAI210     o122(.A0(ori_n132_), .A1(i7), .B0(ori_n130_), .Y(ori_n133_));
  AOI210     o123(.A0(ori_n129_), .A1(ori_n41_), .B0(ori_n133_), .Y(ori_n134_));
  OAI210     o124(.A0(i4), .A1(ori_n17_), .B0(ori_n48_), .Y(ori_n135_));
  NA2        o125(.A(ori_n54_), .B(ori_n52_), .Y(ori_n136_));
  NO2        o126(.A(i3), .B(ori_n39_), .Y(ori_n137_));
  AOI220     o127(.A0(ori_n137_), .A1(ori_n136_), .B0(ori_n135_), .B1(ori_n66_), .Y(ori_n138_));
  OAI220     o128(.A0(ori_n138_), .A1(i7), .B0(ori_n134_), .B1(i1), .Y(ori_n139_));
  NA2        o129(.A(ori_n41_), .B(i1), .Y(ori_n140_));
  NOi21      o130(.An(ori_n140_), .B(ori_n119_), .Y(ori_n141_));
  NA2        o131(.A(ori_n78_), .B(ori_n17_), .Y(ori_n142_));
  NO2        o132(.A(ori_n79_), .B(i7), .Y(ori_n143_));
  OAI210     o133(.A0(ori_n131_), .A1(ori_n108_), .B0(ori_n143_), .Y(ori_n144_));
  OAI210     o134(.A0(ori_n142_), .A1(ori_n141_), .B0(ori_n144_), .Y(ori_n145_));
  AOI210     o135(.A0(ori_n13_), .A1(i5), .B0(ori_n40_), .Y(ori_n146_));
  NA2        o136(.A(ori_n15_), .B(i4), .Y(ori_n147_));
  OAI220     o137(.A0(ori_n147_), .A1(ori_n146_), .B0(ori_n140_), .B1(ori_n102_), .Y(ori_n148_));
  MUX2       o138(.S(i6), .A(ori_n148_), .B(ori_n145_), .Y(ori_n149_));
  AOI210     o139(.A0(ori_n139_), .A1(i0), .B0(ori_n149_), .Y(ori_n150_));
  NA4        o140(.A(ori_n150_), .B(ori_n127_), .C(ori_n94_), .D(ori_n72_), .Y(zori10));
  INV        m000(.A(i5), .Y(mai_n11_));
  NO2        m001(.A(mai_n11_), .B(i3), .Y(mai_n12_));
  INV        m002(.A(i7), .Y(mai_n13_));
  NA2        m003(.A(i8), .B(mai_n13_), .Y(mai_n14_));
  NOi21      m004(.An(mai_n14_), .B(mai_n12_), .Y(mai_n15_));
  NO2        m005(.A(mai_n15_), .B(i0), .Y(mai_n16_));
  INV        m006(.A(i3), .Y(mai_n17_));
  INV        m007(.A(i6), .Y(mai_n18_));
  NA2        m008(.A(mai_n18_), .B(mai_n17_), .Y(mai_n19_));
  NO2        m009(.A(mai_n19_), .B(mai_n13_), .Y(mai_n20_));
  OAI210     m010(.A0(mai_n20_), .A1(mai_n16_), .B0(i1), .Y(mai_n21_));
  INV        m011(.A(i0), .Y(mai_n22_));
  INV        m012(.A(i8), .Y(mai_n23_));
  NO2        m013(.A(i7), .B(mai_n17_), .Y(mai_n24_));
  NA2        m014(.A(mai_n24_), .B(mai_n23_), .Y(mai_n25_));
  NO2        m015(.A(mai_n18_), .B(i5), .Y(mai_n26_));
  NA2        m016(.A(mai_n26_), .B(mai_n17_), .Y(mai_n27_));
  AOI210     m017(.A0(mai_n27_), .A1(mai_n25_), .B0(mai_n22_), .Y(mai_n28_));
  NA2        m018(.A(mai_n26_), .B(i8), .Y(mai_n29_));
  NA3        m019(.A(i7), .B(i3), .C(mai_n22_), .Y(mai_n30_));
  AOI210     m020(.A0(mai_n30_), .A1(mai_n29_), .B0(i1), .Y(mai_n31_));
  NO4        m021(.A(mai_n13_), .B(mai_n18_), .C(i5), .D(i0), .Y(mai_n32_));
  NAi21      m022(.An(i6), .B(i5), .Y(mai_n33_));
  NA2        m023(.A(mai_n11_), .B(i1), .Y(mai_n34_));
  NA2        m024(.A(mai_n23_), .B(i3), .Y(mai_n35_));
  AOI210     m025(.A0(mai_n34_), .A1(mai_n33_), .B0(mai_n35_), .Y(mai_n36_));
  NO4        m026(.A(mai_n36_), .B(mai_n32_), .C(mai_n31_), .D(mai_n28_), .Y(mai_n37_));
  AOI210     m027(.A0(mai_n37_), .A1(mai_n21_), .B0(i4), .Y(mai_n38_));
  INV        m028(.A(i1), .Y(mai_n39_));
  NO2        m029(.A(mai_n23_), .B(i3), .Y(mai_n40_));
  INV        m030(.A(i4), .Y(mai_n41_));
  NO2        m031(.A(i6), .B(mai_n41_), .Y(mai_n42_));
  OAI210     m032(.A0(mai_n42_), .A1(mai_n40_), .B0(i0), .Y(mai_n43_));
  NO2        m033(.A(i8), .B(mai_n18_), .Y(mai_n44_));
  NO2        m034(.A(mai_n23_), .B(i0), .Y(mai_n45_));
  OAI210     m035(.A0(mai_n45_), .A1(mai_n44_), .B0(i3), .Y(mai_n46_));
  AOI210     m036(.A0(mai_n46_), .A1(mai_n43_), .B0(i7), .Y(mai_n47_));
  NAi21      m037(.An(i5), .B(i4), .Y(mai_n48_));
  AOI210     m038(.A0(mai_n48_), .A1(mai_n33_), .B0(i0), .Y(mai_n49_));
  AOI210     m039(.A0(mai_n40_), .A1(mai_n11_), .B0(mai_n49_), .Y(mai_n50_));
  NAi21      m040(.An(i6), .B(i7), .Y(mai_n51_));
  NAi21      m041(.An(i8), .B(i5), .Y(mai_n52_));
  OAI220     m042(.A0(mai_n52_), .A1(i3), .B0(mai_n51_), .B1(i5), .Y(mai_n53_));
  NAi21      m043(.An(i6), .B(i8), .Y(mai_n54_));
  OAI210     m044(.A0(mai_n18_), .A1(i0), .B0(mai_n54_), .Y(mai_n55_));
  AOI220     m045(.A0(mai_n55_), .A1(mai_n12_), .B0(mai_n53_), .B1(i0), .Y(mai_n56_));
  OAI210     m046(.A0(mai_n50_), .A1(mai_n13_), .B0(mai_n56_), .Y(mai_n57_));
  OAI210     m047(.A0(mai_n57_), .A1(mai_n47_), .B0(mai_n39_), .Y(mai_n58_));
  NO2        m048(.A(i8), .B(mai_n17_), .Y(mai_n59_));
  AOI220     m049(.A0(mai_n45_), .A1(mai_n13_), .B0(mai_n59_), .B1(mai_n18_), .Y(mai_n60_));
  OAI220     m050(.A0(i7), .A1(mai_n11_), .B0(i6), .B1(mai_n39_), .Y(mai_n61_));
  AOI220     m051(.A0(mai_n61_), .A1(mai_n22_), .B0(mai_n44_), .B1(mai_n13_), .Y(mai_n62_));
  OAI220     m052(.A0(mai_n62_), .A1(i3), .B0(mai_n60_), .B1(i5), .Y(mai_n63_));
  NA2        m053(.A(mai_n23_), .B(i0), .Y(mai_n64_));
  OR2        m054(.A(mai_n64_), .B(mai_n19_), .Y(mai_n65_));
  NO2        m055(.A(mai_n23_), .B(i6), .Y(mai_n66_));
  NO2        m056(.A(i7), .B(i0), .Y(mai_n67_));
  OAI210     m057(.A0(mai_n66_), .A1(mai_n44_), .B0(mai_n67_), .Y(mai_n68_));
  AOI210     m058(.A0(mai_n68_), .A1(mai_n65_), .B0(mai_n39_), .Y(mai_n69_));
  AOI210     m059(.A0(mai_n63_), .A1(i4), .B0(mai_n69_), .Y(mai_n70_));
  NA2        m060(.A(mai_n70_), .B(mai_n58_), .Y(mai_n71_));
  OAI210     m061(.A0(mai_n71_), .A1(mai_n38_), .B0(i2), .Y(mai_n72_));
  AOI210     m062(.A0(mai_n54_), .A1(mai_n35_), .B0(i4), .Y(mai_n73_));
  NO3        m063(.A(i8), .B(mai_n41_), .C(i3), .Y(mai_n74_));
  OAI210     m064(.A0(mai_n74_), .A1(mai_n73_), .B0(i5), .Y(mai_n75_));
  NO2        m065(.A(mai_n17_), .B(i2), .Y(mai_n76_));
  NO2        m066(.A(i8), .B(mai_n13_), .Y(mai_n77_));
  NAi21      m067(.An(mai_n77_), .B(mai_n14_), .Y(mai_n78_));
  NA2        m068(.A(mai_n11_), .B(i3), .Y(mai_n79_));
  INV        m069(.A(i2), .Y(mai_n80_));
  NO2        m070(.A(mai_n13_), .B(i5), .Y(mai_n81_));
  AOI210     m071(.A0(i8), .A1(mai_n80_), .B0(mai_n81_), .Y(mai_n82_));
  OAI220     m072(.A0(mai_n82_), .A1(i3), .B0(mai_n79_), .B1(i6), .Y(mai_n83_));
  AOI220     m073(.A0(mai_n83_), .A1(i4), .B0(mai_n78_), .B1(mai_n76_), .Y(mai_n84_));
  AOI210     m074(.A0(mai_n84_), .A1(mai_n75_), .B0(mai_n39_), .Y(mai_n85_));
  NO2        m075(.A(mai_n11_), .B(i1), .Y(mai_n86_));
  NOi21      m076(.An(mai_n34_), .B(mai_n86_), .Y(mai_n87_));
  AOI220     m077(.A0(mai_n76_), .A1(i8), .B0(mai_n44_), .B1(i4), .Y(mai_n88_));
  NA3        m078(.A(i6), .B(mai_n41_), .C(i3), .Y(mai_n89_));
  OAI210     m079(.A0(mai_n33_), .A1(mai_n41_), .B0(mai_n89_), .Y(mai_n90_));
  NO2        m080(.A(mai_n35_), .B(mai_n33_), .Y(mai_n91_));
  AOI210     m081(.A0(mai_n90_), .A1(mai_n80_), .B0(mai_n91_), .Y(mai_n92_));
  OAI220     m082(.A0(mai_n92_), .A1(mai_n13_), .B0(mai_n88_), .B1(mai_n87_), .Y(mai_n93_));
  OAI210     m083(.A0(mai_n93_), .A1(mai_n85_), .B0(mai_n22_), .Y(mai_n94_));
  NO2        m084(.A(i8), .B(mai_n22_), .Y(mai_n95_));
  OAI210     m085(.A0(mai_n95_), .A1(mai_n26_), .B0(i3), .Y(mai_n96_));
  NO2        m086(.A(i7), .B(i6), .Y(mai_n97_));
  NA2        m087(.A(i7), .B(i6), .Y(mai_n98_));
  NOi21      m088(.An(mai_n98_), .B(mai_n97_), .Y(mai_n99_));
  NA2        m089(.A(mai_n99_), .B(i5), .Y(mai_n100_));
  AO210      m090(.A0(mai_n100_), .A1(mai_n96_), .B0(i4), .Y(mai_n101_));
  NA2        m091(.A(mai_n81_), .B(i8), .Y(mai_n102_));
  OAI210     m092(.A0(mai_n97_), .A1(mai_n64_), .B0(mai_n102_), .Y(mai_n103_));
  AOI220     m093(.A0(mai_n103_), .A1(mai_n17_), .B0(mai_n95_), .B1(mai_n42_), .Y(mai_n104_));
  AOI210     m094(.A0(mai_n104_), .A1(mai_n101_), .B0(mai_n39_), .Y(mai_n105_));
  AOI210     m095(.A0(i7), .A1(mai_n39_), .B0(mai_n40_), .Y(mai_n106_));
  OAI210     m096(.A0(mai_n106_), .A1(i4), .B0(mai_n25_), .Y(mai_n107_));
  NO2        m097(.A(i8), .B(mai_n41_), .Y(mai_n108_));
  AOI220     m098(.A0(mai_n108_), .A1(mai_n39_), .B0(mai_n24_), .B1(mai_n18_), .Y(mai_n109_));
  OAI210     m099(.A0(i7), .A1(mai_n41_), .B0(mai_n51_), .Y(mai_n110_));
  NA2        m100(.A(mai_n110_), .B(mai_n40_), .Y(mai_n111_));
  OAI210     m101(.A0(mai_n109_), .A1(mai_n22_), .B0(mai_n111_), .Y(mai_n112_));
  AOI210     m102(.A0(mai_n107_), .A1(i6), .B0(mai_n112_), .Y(mai_n113_));
  NO3        m103(.A(i6), .B(i5), .C(mai_n17_), .Y(mai_n114_));
  NO3        m104(.A(i8), .B(mai_n18_), .C(i1), .Y(mai_n115_));
  OAI210     m105(.A0(mai_n115_), .A1(mai_n114_), .B0(i4), .Y(mai_n116_));
  NA3        m106(.A(mai_n99_), .B(i8), .C(mai_n39_), .Y(mai_n117_));
  AOI210     m107(.A0(mai_n117_), .A1(mai_n116_), .B0(mai_n22_), .Y(mai_n118_));
  NO2        m108(.A(i5), .B(mai_n41_), .Y(mai_n119_));
  NA2        m109(.A(mai_n119_), .B(mai_n59_), .Y(mai_n120_));
  NA2        m110(.A(i5), .B(i3), .Y(mai_n121_));
  NA4        m111(.A(mai_n121_), .B(mai_n19_), .C(i8), .D(mai_n39_), .Y(mai_n122_));
  AOI210     m112(.A0(mai_n122_), .A1(mai_n120_), .B0(mai_n13_), .Y(mai_n123_));
  NO4        m113(.A(mai_n79_), .B(mai_n23_), .C(i7), .D(mai_n41_), .Y(mai_n124_));
  NO3        m114(.A(mai_n124_), .B(mai_n123_), .C(mai_n118_), .Y(mai_n125_));
  OAI210     m115(.A0(mai_n113_), .A1(mai_n11_), .B0(mai_n125_), .Y(mai_n126_));
  OAI210     m116(.A0(mai_n126_), .A1(mai_n105_), .B0(mai_n80_), .Y(mai_n127_));
  AOI210     m117(.A0(i7), .A1(mai_n17_), .B0(mai_n44_), .Y(mai_n128_));
  OAI220     m118(.A0(mai_n128_), .A1(mai_n11_), .B0(mai_n51_), .B1(mai_n17_), .Y(mai_n129_));
  OAI210     m119(.A0(mai_n42_), .A1(mai_n26_), .B0(mai_n77_), .Y(mai_n130_));
  NO2        m120(.A(mai_n23_), .B(i4), .Y(mai_n131_));
  AOI220     m121(.A0(mai_n131_), .A1(i5), .B0(mai_n26_), .B1(i3), .Y(mai_n132_));
  OAI210     m122(.A0(mai_n132_), .A1(i7), .B0(mai_n130_), .Y(mai_n133_));
  AOI210     m123(.A0(mai_n129_), .A1(mai_n41_), .B0(mai_n133_), .Y(mai_n134_));
  OAI210     m124(.A0(i4), .A1(mai_n17_), .B0(mai_n48_), .Y(mai_n135_));
  NA2        m125(.A(mai_n54_), .B(mai_n52_), .Y(mai_n136_));
  NO2        m126(.A(i3), .B(mai_n39_), .Y(mai_n137_));
  AOI220     m127(.A0(mai_n137_), .A1(mai_n136_), .B0(mai_n135_), .B1(mai_n66_), .Y(mai_n138_));
  OAI220     m128(.A0(mai_n138_), .A1(i7), .B0(mai_n134_), .B1(i1), .Y(mai_n139_));
  NA2        m129(.A(mai_n41_), .B(i1), .Y(mai_n140_));
  NOi21      m130(.An(mai_n140_), .B(mai_n119_), .Y(mai_n141_));
  NA2        m131(.A(mai_n78_), .B(mai_n17_), .Y(mai_n142_));
  NO2        m132(.A(mai_n79_), .B(i7), .Y(mai_n143_));
  OAI210     m133(.A0(mai_n131_), .A1(mai_n108_), .B0(mai_n143_), .Y(mai_n144_));
  OAI210     m134(.A0(mai_n142_), .A1(mai_n141_), .B0(mai_n144_), .Y(mai_n145_));
  AOI210     m135(.A0(mai_n13_), .A1(i5), .B0(mai_n40_), .Y(mai_n146_));
  NA2        m136(.A(mai_n15_), .B(i4), .Y(mai_n147_));
  OAI220     m137(.A0(mai_n147_), .A1(mai_n146_), .B0(mai_n140_), .B1(mai_n102_), .Y(mai_n148_));
  MUX2       m138(.S(i6), .A(mai_n148_), .B(mai_n145_), .Y(mai_n149_));
  AOI210     m139(.A0(mai_n139_), .A1(i0), .B0(mai_n149_), .Y(mai_n150_));
  NA4        m140(.A(mai_n150_), .B(mai_n127_), .C(mai_n94_), .D(mai_n72_), .Y(zori20));
  INV        u000(.A(i5), .Y(men_n11_));
  NO2        u001(.A(men_n11_), .B(i3), .Y(men_n12_));
  INV        u002(.A(i7), .Y(men_n13_));
  NA2        u003(.A(i8), .B(men_n13_), .Y(men_n14_));
  NOi21      u004(.An(men_n14_), .B(men_n12_), .Y(men_n15_));
  NO2        u005(.A(men_n15_), .B(i0), .Y(men_n16_));
  INV        u006(.A(i3), .Y(men_n17_));
  INV        u007(.A(i6), .Y(men_n18_));
  NA2        u008(.A(men_n18_), .B(men_n17_), .Y(men_n19_));
  NO2        u009(.A(men_n19_), .B(men_n13_), .Y(men_n20_));
  OAI210     u010(.A0(men_n20_), .A1(men_n16_), .B0(i1), .Y(men_n21_));
  INV        u011(.A(i0), .Y(men_n22_));
  INV        u012(.A(i8), .Y(men_n23_));
  NO2        u013(.A(i7), .B(men_n17_), .Y(men_n24_));
  NA2        u014(.A(men_n24_), .B(men_n23_), .Y(men_n25_));
  NO2        u015(.A(men_n18_), .B(i5), .Y(men_n26_));
  NA2        u016(.A(men_n26_), .B(men_n17_), .Y(men_n27_));
  AOI210     u017(.A0(men_n27_), .A1(men_n25_), .B0(men_n22_), .Y(men_n28_));
  NA2        u018(.A(men_n26_), .B(i8), .Y(men_n29_));
  NA3        u019(.A(i7), .B(i3), .C(men_n22_), .Y(men_n30_));
  AOI210     u020(.A0(men_n30_), .A1(men_n29_), .B0(i1), .Y(men_n31_));
  NO4        u021(.A(men_n13_), .B(men_n18_), .C(i5), .D(i0), .Y(men_n32_));
  NAi21      u022(.An(i6), .B(i5), .Y(men_n33_));
  NA2        u023(.A(men_n11_), .B(i1), .Y(men_n34_));
  NA2        u024(.A(men_n23_), .B(i3), .Y(men_n35_));
  AOI210     u025(.A0(men_n34_), .A1(men_n33_), .B0(men_n35_), .Y(men_n36_));
  NO4        u026(.A(men_n36_), .B(men_n32_), .C(men_n31_), .D(men_n28_), .Y(men_n37_));
  AOI210     u027(.A0(men_n37_), .A1(men_n21_), .B0(i4), .Y(men_n38_));
  INV        u028(.A(i1), .Y(men_n39_));
  NO2        u029(.A(men_n23_), .B(i3), .Y(men_n40_));
  INV        u030(.A(i4), .Y(men_n41_));
  NO2        u031(.A(i6), .B(men_n41_), .Y(men_n42_));
  OAI210     u032(.A0(men_n42_), .A1(men_n40_), .B0(i0), .Y(men_n43_));
  NO2        u033(.A(i8), .B(men_n18_), .Y(men_n44_));
  NO2        u034(.A(men_n23_), .B(i0), .Y(men_n45_));
  OAI210     u035(.A0(men_n45_), .A1(men_n44_), .B0(i3), .Y(men_n46_));
  AOI210     u036(.A0(men_n46_), .A1(men_n43_), .B0(i7), .Y(men_n47_));
  NAi21      u037(.An(i5), .B(i4), .Y(men_n48_));
  AOI210     u038(.A0(men_n48_), .A1(men_n33_), .B0(i0), .Y(men_n49_));
  AOI210     u039(.A0(men_n40_), .A1(men_n11_), .B0(men_n49_), .Y(men_n50_));
  NAi21      u040(.An(i6), .B(i7), .Y(men_n51_));
  NAi21      u041(.An(i8), .B(i5), .Y(men_n52_));
  OAI220     u042(.A0(men_n52_), .A1(i3), .B0(men_n51_), .B1(i5), .Y(men_n53_));
  NAi21      u043(.An(i6), .B(i8), .Y(men_n54_));
  OAI210     u044(.A0(men_n18_), .A1(i0), .B0(men_n54_), .Y(men_n55_));
  AOI220     u045(.A0(men_n55_), .A1(men_n12_), .B0(men_n53_), .B1(i0), .Y(men_n56_));
  OAI210     u046(.A0(men_n50_), .A1(men_n13_), .B0(men_n56_), .Y(men_n57_));
  OAI210     u047(.A0(men_n57_), .A1(men_n47_), .B0(men_n39_), .Y(men_n58_));
  NO2        u048(.A(i8), .B(men_n17_), .Y(men_n59_));
  AOI220     u049(.A0(men_n45_), .A1(men_n13_), .B0(men_n59_), .B1(men_n18_), .Y(men_n60_));
  OAI220     u050(.A0(i7), .A1(men_n11_), .B0(i6), .B1(men_n39_), .Y(men_n61_));
  AOI220     u051(.A0(men_n61_), .A1(men_n22_), .B0(men_n44_), .B1(men_n13_), .Y(men_n62_));
  OAI220     u052(.A0(men_n62_), .A1(i3), .B0(men_n60_), .B1(i5), .Y(men_n63_));
  NA2        u053(.A(men_n23_), .B(i0), .Y(men_n64_));
  OR2        u054(.A(men_n64_), .B(men_n19_), .Y(men_n65_));
  NO2        u055(.A(men_n23_), .B(i6), .Y(men_n66_));
  NO2        u056(.A(i7), .B(i0), .Y(men_n67_));
  OAI210     u057(.A0(men_n66_), .A1(men_n44_), .B0(men_n67_), .Y(men_n68_));
  AOI210     u058(.A0(men_n68_), .A1(men_n65_), .B0(men_n39_), .Y(men_n69_));
  AOI210     u059(.A0(men_n63_), .A1(i4), .B0(men_n69_), .Y(men_n70_));
  NA2        u060(.A(men_n70_), .B(men_n58_), .Y(men_n71_));
  OAI210     u061(.A0(men_n71_), .A1(men_n38_), .B0(i2), .Y(men_n72_));
  AOI210     u062(.A0(men_n54_), .A1(men_n35_), .B0(i4), .Y(men_n73_));
  NO3        u063(.A(i8), .B(men_n41_), .C(i3), .Y(men_n74_));
  OAI210     u064(.A0(men_n74_), .A1(men_n73_), .B0(i5), .Y(men_n75_));
  NO2        u065(.A(men_n17_), .B(i2), .Y(men_n76_));
  NO2        u066(.A(i8), .B(men_n13_), .Y(men_n77_));
  NAi21      u067(.An(men_n77_), .B(men_n14_), .Y(men_n78_));
  NA2        u068(.A(men_n11_), .B(i3), .Y(men_n79_));
  INV        u069(.A(i2), .Y(men_n80_));
  NO2        u070(.A(men_n13_), .B(i5), .Y(men_n81_));
  AOI210     u071(.A0(i8), .A1(men_n80_), .B0(men_n81_), .Y(men_n82_));
  OAI220     u072(.A0(men_n82_), .A1(i3), .B0(men_n79_), .B1(i6), .Y(men_n83_));
  AOI220     u073(.A0(men_n83_), .A1(i4), .B0(men_n78_), .B1(men_n76_), .Y(men_n84_));
  AOI210     u074(.A0(men_n84_), .A1(men_n75_), .B0(men_n39_), .Y(men_n85_));
  NO2        u075(.A(men_n11_), .B(i1), .Y(men_n86_));
  NOi21      u076(.An(men_n34_), .B(men_n86_), .Y(men_n87_));
  AOI220     u077(.A0(men_n76_), .A1(i8), .B0(men_n44_), .B1(i4), .Y(men_n88_));
  NA3        u078(.A(i6), .B(men_n41_), .C(i3), .Y(men_n89_));
  OAI210     u079(.A0(men_n33_), .A1(men_n41_), .B0(men_n89_), .Y(men_n90_));
  NO2        u080(.A(men_n35_), .B(men_n33_), .Y(men_n91_));
  AOI210     u081(.A0(men_n90_), .A1(men_n80_), .B0(men_n91_), .Y(men_n92_));
  OAI220     u082(.A0(men_n92_), .A1(men_n13_), .B0(men_n88_), .B1(men_n87_), .Y(men_n93_));
  OAI210     u083(.A0(men_n93_), .A1(men_n85_), .B0(men_n22_), .Y(men_n94_));
  NO2        u084(.A(i8), .B(men_n22_), .Y(men_n95_));
  OAI210     u085(.A0(men_n95_), .A1(men_n26_), .B0(i3), .Y(men_n96_));
  NO2        u086(.A(i7), .B(i6), .Y(men_n97_));
  NA2        u087(.A(i7), .B(i6), .Y(men_n98_));
  NOi21      u088(.An(men_n98_), .B(men_n97_), .Y(men_n99_));
  NA2        u089(.A(men_n99_), .B(i5), .Y(men_n100_));
  AO210      u090(.A0(men_n100_), .A1(men_n96_), .B0(i4), .Y(men_n101_));
  NA2        u091(.A(men_n81_), .B(i8), .Y(men_n102_));
  OAI210     u092(.A0(men_n97_), .A1(men_n64_), .B0(men_n102_), .Y(men_n103_));
  AOI220     u093(.A0(men_n103_), .A1(men_n17_), .B0(men_n95_), .B1(men_n42_), .Y(men_n104_));
  AOI210     u094(.A0(men_n104_), .A1(men_n101_), .B0(men_n39_), .Y(men_n105_));
  AOI210     u095(.A0(i7), .A1(men_n39_), .B0(men_n40_), .Y(men_n106_));
  OAI210     u096(.A0(men_n106_), .A1(i4), .B0(men_n25_), .Y(men_n107_));
  NO2        u097(.A(i8), .B(men_n41_), .Y(men_n108_));
  AOI220     u098(.A0(men_n108_), .A1(men_n39_), .B0(men_n24_), .B1(men_n18_), .Y(men_n109_));
  OAI210     u099(.A0(i7), .A1(men_n41_), .B0(men_n51_), .Y(men_n110_));
  NA2        u100(.A(men_n110_), .B(men_n40_), .Y(men_n111_));
  OAI210     u101(.A0(men_n109_), .A1(men_n22_), .B0(men_n111_), .Y(men_n112_));
  AOI210     u102(.A0(men_n107_), .A1(i6), .B0(men_n112_), .Y(men_n113_));
  NO3        u103(.A(i6), .B(i5), .C(men_n17_), .Y(men_n114_));
  NO3        u104(.A(i8), .B(men_n18_), .C(i1), .Y(men_n115_));
  OAI210     u105(.A0(men_n115_), .A1(men_n114_), .B0(i4), .Y(men_n116_));
  NA3        u106(.A(men_n99_), .B(i8), .C(men_n39_), .Y(men_n117_));
  AOI210     u107(.A0(men_n117_), .A1(men_n116_), .B0(men_n22_), .Y(men_n118_));
  NO2        u108(.A(i5), .B(men_n41_), .Y(men_n119_));
  NA2        u109(.A(men_n119_), .B(men_n59_), .Y(men_n120_));
  NA2        u110(.A(i5), .B(i3), .Y(men_n121_));
  NA4        u111(.A(men_n121_), .B(men_n19_), .C(i8), .D(men_n39_), .Y(men_n122_));
  AOI210     u112(.A0(men_n122_), .A1(men_n120_), .B0(men_n13_), .Y(men_n123_));
  NO4        u113(.A(men_n79_), .B(men_n23_), .C(i7), .D(men_n41_), .Y(men_n124_));
  NO3        u114(.A(men_n124_), .B(men_n123_), .C(men_n118_), .Y(men_n125_));
  OAI210     u115(.A0(men_n113_), .A1(men_n11_), .B0(men_n125_), .Y(men_n126_));
  OAI210     u116(.A0(men_n126_), .A1(men_n105_), .B0(men_n80_), .Y(men_n127_));
  AOI210     u117(.A0(i7), .A1(men_n17_), .B0(men_n44_), .Y(men_n128_));
  OAI220     u118(.A0(men_n128_), .A1(men_n11_), .B0(men_n51_), .B1(men_n17_), .Y(men_n129_));
  OAI210     u119(.A0(men_n42_), .A1(men_n26_), .B0(men_n77_), .Y(men_n130_));
  NO2        u120(.A(men_n23_), .B(i4), .Y(men_n131_));
  AOI220     u121(.A0(men_n131_), .A1(i5), .B0(men_n26_), .B1(i3), .Y(men_n132_));
  OAI210     u122(.A0(men_n132_), .A1(i7), .B0(men_n130_), .Y(men_n133_));
  AOI210     u123(.A0(men_n129_), .A1(men_n41_), .B0(men_n133_), .Y(men_n134_));
  OAI210     u124(.A0(i4), .A1(men_n17_), .B0(men_n48_), .Y(men_n135_));
  NA2        u125(.A(men_n54_), .B(men_n52_), .Y(men_n136_));
  NO2        u126(.A(i3), .B(men_n39_), .Y(men_n137_));
  AOI220     u127(.A0(men_n137_), .A1(men_n136_), .B0(men_n135_), .B1(men_n66_), .Y(men_n138_));
  OAI220     u128(.A0(men_n138_), .A1(i7), .B0(men_n134_), .B1(i1), .Y(men_n139_));
  NA2        u129(.A(men_n41_), .B(i1), .Y(men_n140_));
  NOi21      u130(.An(men_n140_), .B(men_n119_), .Y(men_n141_));
  NA2        u131(.A(men_n78_), .B(men_n17_), .Y(men_n142_));
  NO2        u132(.A(men_n79_), .B(i7), .Y(men_n143_));
  OAI210     u133(.A0(men_n131_), .A1(men_n108_), .B0(men_n143_), .Y(men_n144_));
  OAI210     u134(.A0(men_n142_), .A1(men_n141_), .B0(men_n144_), .Y(men_n145_));
  AOI210     u135(.A0(men_n13_), .A1(i5), .B0(men_n40_), .Y(men_n146_));
  NA2        u136(.A(men_n15_), .B(i4), .Y(men_n147_));
  OAI220     u137(.A0(men_n147_), .A1(men_n146_), .B0(men_n140_), .B1(men_n102_), .Y(men_n148_));
  MUX2       u138(.S(i6), .A(men_n148_), .B(men_n145_), .Y(men_n149_));
  AOI210     u139(.A0(men_n139_), .A1(i0), .B0(men_n149_), .Y(men_n150_));
  NA4        u140(.A(men_n150_), .B(men_n127_), .C(men_n94_), .D(men_n72_), .Y(zori30));
  VOTADOR g0(.A(zori10), .B(zori20), .C(zori30), .Y(z0));
endmodule