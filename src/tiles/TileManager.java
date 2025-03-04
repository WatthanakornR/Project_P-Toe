package tiles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.GamePanel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;






public class TileManager {
	GamePanel gp;
	public Tile[] tile;
	public int[][] mapTileNum;

	public TileManager(GamePanel gp) {
		this.gp = gp;

		this.tile = new Tile[10000];
		this.mapTileNum = new int[50][50];

		getTileImage();
		loadMap("/assets/maps/world01.txt");
	}

	public void getTileImage() {
		try {

			this.tile[0] = new Tile();
			this.tile[0].image = new Image(getClass().getResourceAsStream("/assets/backgrounds/grass.png"));

			this.tile[1] = new Tile();
			this.tile[1].image = new Image(getClass().getResourceAsStream("/assets/backgrounds/wall.png"));
			this.tile[1].collision = true;

			this.tile[2] = new Tile();
			this.tile[2].image = new Image(getClass().getResourceAsStream("/assets/backgrounds/water.png"));
			this.tile[2].collision = true;

			this.tile[3] = new Tile();
			this.tile[3].image = new Image(getClass().getResourceAsStream("/assets/backgrounds/earth.png"));

			this.tile[4] = new Tile();
			this.tile[4].image = new Image(getClass().getResourceAsStream("/assets/backgrounds/tree.png"));
			this.tile[4].collision = true;

			this.tile[5] = new Tile();
			this.tile[5].image = new Image(getClass().getResourceAsStream("/assets/backgrounds/sand.png"));

			this.tile[6] = new Tile();
			this.tile[6].image = new Image(getClass().getResourceAsStream("/objects/door.png"));

			this.tile[1001] = new Tile();
			this.tile[1001].image = new Image(getClass().getResourceAsStream("/assets/Pmap/1.png"));
			this.tile[1001].collision = true;

			this.tile[1002] = new Tile();
			this.tile[1002].image = new Image(getClass().getResourceAsStream("/assets/Pmap/2.png"));
			this.tile[1002].collision = true;

			this.tile[1003] = new Tile();
			this.tile[1003].image = new Image(getClass().getResourceAsStream("/assets/Pmap/3.png"));
			this.tile[1003].collision = true;

			this.tile[1004] = new Tile();
			this.tile[1004].image = new Image(getClass().getResourceAsStream("/assets/Pmap/4.png"));
			this.tile[1004].collision = true;

			this.tile[1005] = new Tile();
			this.tile[1005].image = new Image(getClass().getResourceAsStream("/assets/Pmap/5.png"));
			this.tile[1005].collision = true;

			this.tile[1006] = new Tile();
			this.tile[1006].image = new Image(getClass().getResourceAsStream("/assets/Pmap/6.png"));
			this.tile[1006].collision = true;

			this.tile[1007] = new Tile();
			this.tile[1007].image = new Image(getClass().getResourceAsStream("/assets/Pmap/7.png"));
			this.tile[1007].collision = true;

			this.tile[1008] = new Tile();
			this.tile[1008].image = new Image(getClass().getResourceAsStream("/assets/Pmap/8.png"));
			this.tile[1008].collision = true;

			this.tile[1009] = new Tile();
			this.tile[1009].image = new Image(getClass().getResourceAsStream("/assets/Pmap/9.png"));
			this.tile[1009].collision = true;

			this.tile[1010] = new Tile();
			this.tile[1010].image = new Image(getClass().getResourceAsStream("/assets/Pmap/10.png"));
			this.tile[1010].collision = true;

			this.tile[1011] = new Tile();
			this.tile[1011].image = new Image(getClass().getResourceAsStream("/assets/Pmap/11.png"));
			this.tile[1011].collision = true;

			this.tile[1012] = new Tile();
			this.tile[1012].image = new Image(getClass().getResourceAsStream("/assets/Pmap/12.png"));
			this.tile[1012].collision = true;

			this.tile[1013] = new Tile();
			this.tile[1013].image = new Image(getClass().getResourceAsStream("/assets/Pmap/13.png"));
			this.tile[1013].collision = true;

			this.tile[1014] = new Tile();
			this.tile[1014].image = new Image(getClass().getResourceAsStream("/assets/Pmap/14.png"));
			this.tile[1014].collision = true;

			this.tile[1015] = new Tile();
			this.tile[1015].image = new Image(getClass().getResourceAsStream("/assets/Pmap/15.png"));
			this.tile[1015].collision = true;

			this.tile[1016] = new Tile();
			this.tile[1016].image = new Image(getClass().getResourceAsStream("/assets/Pmap/16.png"));
			this.tile[1016].collision = true;

			this.tile[1017] = new Tile();
			this.tile[1017].image = new Image(getClass().getResourceAsStream("/assets/Pmap/17.png"));
			this.tile[1017].collision = true;

			this.tile[1018] = new Tile();
			this.tile[1018].image = new Image(getClass().getResourceAsStream("/assets/Pmap/18.png"));
			this.tile[1018].collision = true;

			this.tile[1019] = new Tile();
			this.tile[1019].image = new Image(getClass().getResourceAsStream("/assets/Pmap/19.png"));
			this.tile[1019].collision = true;

			this.tile[1020] = new Tile();
			this.tile[1020].image = new Image(getClass().getResourceAsStream("/assets/Pmap/20.png"));
			this.tile[1020].collision = true;

			this.tile[1021] = new Tile();
			this.tile[1021].image = new Image(getClass().getResourceAsStream("/assets/Pmap/21.png"));
			this.tile[1021].collision = true;

			this.tile[1022] = new Tile();
			this.tile[1022].image = new Image(getClass().getResourceAsStream("/assets/Pmap/22.png"));

			this.tile[1023] = new Tile();
			this.tile[1023].image = new Image(getClass().getResourceAsStream("/assets/Pmap/23.png"));

			this.tile[1024] = new Tile();
			this.tile[1024].image = new Image(getClass().getResourceAsStream("/assets/Pmap/24.png"));

			this.tile[1025] = new Tile();
			this.tile[1025].image = new Image(getClass().getResourceAsStream("/assets/Pmap/25.png"));

			this.tile[1026] = new Tile();
			this.tile[1026].image = new Image(getClass().getResourceAsStream("/assets/Pmap/26.png"));

			this.tile[1027] = new Tile();
			this.tile[1027].image = new Image(getClass().getResourceAsStream("/assets/Pmap/27.png"));

			this.tile[1028] = new Tile();
			this.tile[1028].image = new Image(getClass().getResourceAsStream("/assets/Pmap/28.png"));

			this.tile[1029] = new Tile();
			this.tile[1029].image = new Image(getClass().getResourceAsStream("/assets/Pmap/29.png"));
			this.tile[1029].collision = true;

			this.tile[1030] = new Tile();
			this.tile[1030].image = new Image(getClass().getResourceAsStream("/assets/Pmap/30.png"));
			this.tile[1030].collision = true;

			this.tile[1031] = new Tile();
			this.tile[1031].image = new Image(getClass().getResourceAsStream("/assets/Pmap/31.png"));
			this.tile[1031].collision = true;

			this.tile[1032] = new Tile();
			this.tile[1032].image = new Image(getClass().getResourceAsStream("/assets/Pmap/32.png"));
			this.tile[1032].collision = true;

			this.tile[1033] = new Tile();
			this.tile[1033].image = new Image(getClass().getResourceAsStream("/assets/Pmap/33.png"));
			this.tile[1033].collision = true;

			this.tile[1034] = new Tile();
			this.tile[1034].image = new Image(getClass().getResourceAsStream("/assets/Pmap/34.png"));
			this.tile[1034].collision = true;

			this.tile[1035] = new Tile();
			this.tile[1035].image = new Image(getClass().getResourceAsStream("/assets/Pmap/35.png"));
			this.tile[1035].collision = true;

			this.tile[1036] = new Tile();
			this.tile[1036].image = new Image(getClass().getResourceAsStream("/assets/Pmap/36.png"));
			this.tile[1036].collision = true;

			this.tile[1037] = new Tile();
			this.tile[1037].image = new Image(getClass().getResourceAsStream("/assets/Pmap/37.png"));
			this.tile[1037].collision = true;

			this.tile[1038] = new Tile();
			this.tile[1038].image = new Image(getClass().getResourceAsStream("/assets/Pmap/38.png"));
			this.tile[1038].collision = true;

			this.tile[1039] = new Tile();
			this.tile[1039].image = new Image(getClass().getResourceAsStream("/assets/Pmap/39.png"));
			this.tile[1039].collision = true;

			this.tile[1040] = new Tile();
			this.tile[1040].image = new Image(getClass().getResourceAsStream("/assets/Pmap/40.png"));
			this.tile[1040].collision = true;

			this.tile[1041] = new Tile();
			this.tile[1041].image = new Image(getClass().getResourceAsStream("/assets/Pmap/41.png"));
			this.tile[1041].collision = true;

			this.tile[1042] = new Tile();
			this.tile[1042].image = new Image(getClass().getResourceAsStream("/assets/Pmap/42.png"));
			this.tile[1042].collision = true;

			this.tile[1043] = new Tile();
			this.tile[1043].image = new Image(getClass().getResourceAsStream("/assets/Pmap/43.png"));
			this.tile[1043].collision = true;

			this.tile[1044] = new Tile();
			this.tile[1044].image = new Image(getClass().getResourceAsStream("/assets/Pmap/44.png"));
			this.tile[1044].collision = true;

			this.tile[1045] = new Tile();
			this.tile[1045].image = new Image(getClass().getResourceAsStream("/assets/Pmap/45.png"));
			this.tile[1045].collision = true;

			this.tile[1046] = new Tile();
			this.tile[1046].image = new Image(getClass().getResourceAsStream("/assets/Pmap/46.png"));
			this.tile[1046].collision = true;

			this.tile[1047] = new Tile();
			this.tile[1047].image = new Image(getClass().getResourceAsStream("/assets/Pmap/47.png"));
			this.tile[1047].collision = true;

			this.tile[1048] = new Tile();
			this.tile[1048].image = new Image(getClass().getResourceAsStream("/assets/Pmap/48.png"));
			this.tile[1048].collision = true;

			this.tile[1049] = new Tile();
			this.tile[1049].image = new Image(getClass().getResourceAsStream("/assets/Pmap/49.png"));
			this.tile[1049].collision = true;

			this.tile[1050] = new Tile();
			this.tile[1050].image = new Image(getClass().getResourceAsStream("/assets/Pmap/50.png"));
			this.tile[1050].collision = true;

			this.tile[1051] = new Tile();
			this.tile[1051].image = new Image(getClass().getResourceAsStream("/assets/Pmap/51.png"));
			this.tile[1051].collision = true;

			this.tile[1052] = new Tile();
			this.tile[1052].image = new Image(getClass().getResourceAsStream("/assets/Pmap/52.png"));
			this.tile[1052].collision = true;

			this.tile[1053] = new Tile();
			this.tile[1053].image = new Image(getClass().getResourceAsStream("/assets/Pmap/53.png"));
			this.tile[1053].collision = true;

			this.tile[1054] = new Tile();
			this.tile[1054].image = new Image(getClass().getResourceAsStream("/assets/Pmap/54.png"));
			this.tile[1054].collision = true;

			this.tile[1055] = new Tile();
			this.tile[1055].image = new Image(getClass().getResourceAsStream("/assets/Pmap/55.png"));
			this.tile[1055].collision = true;

			this.tile[1056] = new Tile();
			this.tile[1056].image = new Image(getClass().getResourceAsStream("/assets/Pmap/56.png"));
			this.tile[1056].collision = true;

			this.tile[1057] = new Tile();
			this.tile[1057].image = new Image(getClass().getResourceAsStream("/assets/Pmap/57.png"));
			this.tile[1057].collision = true;

			this.tile[1058] = new Tile();
			this.tile[1058].image = new Image(getClass().getResourceAsStream("/assets/Pmap/58.png"));
			this.tile[1058].collision = true;

			this.tile[1059] = new Tile();
			this.tile[1059].image = new Image(getClass().getResourceAsStream("/assets/Pmap/59.png"));
			this.tile[1059].collision = true;

			this.tile[1060] = new Tile();
			this.tile[1060].image = new Image(getClass().getResourceAsStream("/assets/Pmap/60.png"));
			this.tile[1060].collision = true;

			this.tile[1061] = new Tile();
			this.tile[1061].image = new Image(getClass().getResourceAsStream("/assets/Pmap/61.png"));
			this.tile[1061].collision = true;

			this.tile[1062] = new Tile();
			this.tile[1062].image = new Image(getClass().getResourceAsStream("/assets/Pmap/62.png"));
			this.tile[1062].collision = true;

			this.tile[1063] = new Tile();
			this.tile[1063].image = new Image(getClass().getResourceAsStream("/assets/Pmap/63.png"));
			this.tile[1063].collision = true;

			this.tile[1064] = new Tile();
			this.tile[1064].image = new Image(getClass().getResourceAsStream("/assets/Pmap/64.png"));
			this.tile[1064].collision = true;

			this.tile[1065] = new Tile();
			this.tile[1065].image = new Image(getClass().getResourceAsStream("/assets/Pmap/65.png"));
			this.tile[1065].collision = true;

			this.tile[1066] = new Tile();
			this.tile[1066].image = new Image(getClass().getResourceAsStream("/assets/Pmap/66.png"));
			this.tile[1066].collision = true;

			this.tile[1067] = new Tile();
			this.tile[1067].image = new Image(getClass().getResourceAsStream("/assets/Pmap/67.png"));
			this.tile[1067].collision = true;

			this.tile[1068] = new Tile();
			this.tile[1068].image = new Image(getClass().getResourceAsStream("/assets/Pmap/68.png"));
			this.tile[1068].collision = true;

			this.tile[1069] = new Tile();
			this.tile[1069].image = new Image(getClass().getResourceAsStream("/assets/Pmap/69.png"));
			this.tile[1069].collision = true;

			this.tile[1070] = new Tile();
			this.tile[1070].image = new Image(getClass().getResourceAsStream("/assets/Pmap/70.png"));
			this.tile[1070].collision = true;

			this.tile[1071] = new Tile();
			this.tile[1071].image = new Image(getClass().getResourceAsStream("/assets/Pmap/71.png"));
			this.tile[1071].collision = true;

			this.tile[1072] = new Tile();
			this.tile[1072].image = new Image(getClass().getResourceAsStream("/assets/Pmap/72.png"));

			this.tile[1073] = new Tile();
			this.tile[1073].image = new Image(getClass().getResourceAsStream("/assets/Pmap/73.png"));

			this.tile[1074] = new Tile();
			this.tile[1074].image = new Image(getClass().getResourceAsStream("/assets/Pmap/74.png"));

			this.tile[1075] = new Tile();
			this.tile[1075].image = new Image(getClass().getResourceAsStream("/assets/Pmap/75.png"));

			this.tile[1076] = new Tile();
			this.tile[1076].image = new Image(getClass().getResourceAsStream("/assets/Pmap/76.png"));

			this.tile[1077] = new Tile();
			this.tile[1077].image = new Image(getClass().getResourceAsStream("/assets/Pmap/77.png"));

			this.tile[1078] = new Tile();
			this.tile[1078].image = new Image(getClass().getResourceAsStream("/assets/Pmap/78.png"));

			this.tile[1079] = new Tile();
			this.tile[1079].image = new Image(getClass().getResourceAsStream("/assets/Pmap/79.png"));
			this.tile[1079].collision = true;

			this.tile[1080] = new Tile();
			this.tile[1080].image = new Image(getClass().getResourceAsStream("/assets/Pmap/80.png"));
			this.tile[1080].collision = true;

			this.tile[1081] = new Tile();
			this.tile[1081].image = new Image(getClass().getResourceAsStream("/assets/Pmap/81.png"));
			this.tile[1081].collision = true;

			this.tile[1082] = new Tile();
			this.tile[1082].image = new Image(getClass().getResourceAsStream("/assets/Pmap/82.png"));
			this.tile[1082].collision = true;

			this.tile[1083] = new Tile();
			this.tile[1083].image = new Image(getClass().getResourceAsStream("/assets/Pmap/83.png"));
			this.tile[1083].collision = true;

			this.tile[1084] = new Tile();
			this.tile[1084].image = new Image(getClass().getResourceAsStream("/assets/Pmap/84.png"));
			this.tile[1084].collision = true;

			this.tile[1085] = new Tile();
			this.tile[1085].image = new Image(getClass().getResourceAsStream("/assets/Pmap/85.png"));
			this.tile[1085].collision = true;

			this.tile[1086] = new Tile();
			this.tile[1086].image = new Image(getClass().getResourceAsStream("/assets/Pmap/86.png"));
			this.tile[1086].collision = true;

			this.tile[1087] = new Tile();
			this.tile[1087].image = new Image(getClass().getResourceAsStream("/assets/Pmap/87.png"));
			this.tile[1087].collision = true;

			this.tile[1088] = new Tile();
			this.tile[1088].image = new Image(getClass().getResourceAsStream("/assets/Pmap/88.png"));
			this.tile[1088].collision = true;

			this.tile[1089] = new Tile();
			this.tile[1089].image = new Image(getClass().getResourceAsStream("/assets/Pmap/89.png"));
			this.tile[1089].collision = true;

			this.tile[1090] = new Tile();
			this.tile[1090].image = new Image(getClass().getResourceAsStream("/assets/Pmap/90.png"));
			this.tile[1090].collision = true;

			this.tile[1091] = new Tile();
			this.tile[1091].image = new Image(getClass().getResourceAsStream("/assets/Pmap/91.png"));
			this.tile[1091].collision = true;

			this.tile[1092] = new Tile();
			this.tile[1092].image = new Image(getClass().getResourceAsStream("/assets/Pmap/92.png"));
			this.tile[1092].collision = true;

			this.tile[1093] = new Tile();
			this.tile[1093].image = new Image(getClass().getResourceAsStream("/assets/Pmap/93.png"));
			this.tile[1093].collision = true;

			this.tile[1094] = new Tile();
			this.tile[1094].image = new Image(getClass().getResourceAsStream("/assets/Pmap/94.png"));
			this.tile[1094].collision = true;

			this.tile[1095] = new Tile();
			this.tile[1095].image = new Image(getClass().getResourceAsStream("/assets/Pmap/95.png"));
			this.tile[1095].collision = true;

			this.tile[1096] = new Tile();
			this.tile[1096].image = new Image(getClass().getResourceAsStream("/assets/Pmap/96.png"));
			this.tile[1096].collision = true;

			this.tile[1097] = new Tile();
			this.tile[1097].image = new Image(getClass().getResourceAsStream("/assets/Pmap/97.png"));
			this.tile[1097].collision = true;

			this.tile[1098] = new Tile();
			this.tile[1098].image = new Image(getClass().getResourceAsStream("/assets/Pmap/98.png"));
			this.tile[1098].collision = true;

			this.tile[1099] = new Tile();
			this.tile[1099].image = new Image(getClass().getResourceAsStream("/assets/Pmap/99.png"));
			this.tile[1099].collision = true;

			this.tile[1100] = new Tile();
			this.tile[1100].image = new Image(getClass().getResourceAsStream("/assets/Pmap/100.png"));
			this.tile[1100].collision = true;

			this.tile[1101] = new Tile();
			this.tile[1101].image = new Image(getClass().getResourceAsStream("/assets/Pmap/101.png"));
			this.tile[1101].collision = true;

			this.tile[1102] = new Tile();
			this.tile[1102].image = new Image(getClass().getResourceAsStream("/assets/Pmap/102.png"));
			this.tile[1102].collision = true;

			this.tile[1103] = new Tile();
			this.tile[1103].image = new Image(getClass().getResourceAsStream("/assets/Pmap/103.png"));
			this.tile[1103].collision = true;

			this.tile[1104] = new Tile();
			this.tile[1104].image = new Image(getClass().getResourceAsStream("/assets/Pmap/104.png"));
			this.tile[1104].collision = true;

			this.tile[1105] = new Tile();
			this.tile[1105].image = new Image(getClass().getResourceAsStream("/assets/Pmap/105.png"));
			this.tile[1105].collision = true;

			this.tile[1106] = new Tile();
			this.tile[1106].image = new Image(getClass().getResourceAsStream("/assets/Pmap/106.png"));
			this.tile[1106].collision = true;

			this.tile[1107] = new Tile();
			this.tile[1107].image = new Image(getClass().getResourceAsStream("/assets/Pmap/107.png"));
			this.tile[1107].collision = true;

			this.tile[1108] = new Tile();
			this.tile[1108].image = new Image(getClass().getResourceAsStream("/assets/Pmap/108.png"));
			this.tile[1108].collision = true;

			this.tile[1109] = new Tile();
			this.tile[1109].image = new Image(getClass().getResourceAsStream("/assets/Pmap/109.png"));
			this.tile[1109].collision = true;

			this.tile[1110] = new Tile();
			this.tile[1110].image = new Image(getClass().getResourceAsStream("/assets/Pmap/110.png"));
			this.tile[1110].collision = true;

			this.tile[1111] = new Tile();
			this.tile[1111].image = new Image(getClass().getResourceAsStream("/assets/Pmap/111.png"));
			this.tile[1111].collision = true;

			this.tile[1112] = new Tile();
			this.tile[1112].image = new Image(getClass().getResourceAsStream("/assets/Pmap/112.png"));
			this.tile[1112].collision = true;

			this.tile[1113] = new Tile();
			this.tile[1113].image = new Image(getClass().getResourceAsStream("/assets/Pmap/113.png"));
			this.tile[1113].collision = true;

			this.tile[1114] = new Tile();
			this.tile[1114].image = new Image(getClass().getResourceAsStream("/assets/Pmap/114.png"));
			this.tile[1114].collision = true;

			this.tile[1115] = new Tile();
			this.tile[1115].image = new Image(getClass().getResourceAsStream("/assets/Pmap/115.png"));
			this.tile[1115].collision = true;

			this.tile[1116] = new Tile();
			this.tile[1116].image = new Image(getClass().getResourceAsStream("/assets/Pmap/116.png"));
			this.tile[1116].collision = true;

			this.tile[1117] = new Tile();
			this.tile[1117].image = new Image(getClass().getResourceAsStream("/assets/Pmap/117.png"));
			this.tile[1117].collision = true;

			this.tile[1118] = new Tile();
			this.tile[1118].image = new Image(getClass().getResourceAsStream("/assets/Pmap/118.png"));
			this.tile[1118].collision = true;

			this.tile[1119] = new Tile();
			this.tile[1119].image = new Image(getClass().getResourceAsStream("/assets/Pmap/119.png"));
			this.tile[1119].collision = true;

			this.tile[1120] = new Tile();
			this.tile[1120].image = new Image(getClass().getResourceAsStream("/assets/Pmap/120.png"));
			this.tile[1120].collision = true;

			this.tile[1121] = new Tile();
			this.tile[1121].image = new Image(getClass().getResourceAsStream("/assets/Pmap/121.png"));
			this.tile[1121].collision = true;

			this.tile[1122] = new Tile();
			this.tile[1122].image = new Image(getClass().getResourceAsStream("/assets/Pmap/122.png"));

			this.tile[1123] = new Tile();
			this.tile[1123].image = new Image(getClass().getResourceAsStream("/assets/Pmap/123.png"));

			this.tile[1124] = new Tile();
			this.tile[1124].image = new Image(getClass().getResourceAsStream("/assets/Pmap/124.png"));

			this.tile[1125] = new Tile();
			this.tile[1125].image = new Image(getClass().getResourceAsStream("/assets/Pmap/125.png"));

			this.tile[1126] = new Tile();
			this.tile[1126].image = new Image(getClass().getResourceAsStream("/assets/Pmap/126.png"));

			this.tile[1127] = new Tile();
			this.tile[1127].image = new Image(getClass().getResourceAsStream("/assets/Pmap/127.png"));

			this.tile[1128] = new Tile();
			this.tile[1128].image = new Image(getClass().getResourceAsStream("/assets/Pmap/128.png"));

			this.tile[1129] = new Tile();
			this.tile[1129].image = new Image(getClass().getResourceAsStream("/assets/Pmap/129.png"));
			this.tile[1129].collision = true;

			this.tile[1130] = new Tile();
			this.tile[1130].image = new Image(getClass().getResourceAsStream("/assets/Pmap/130.png"));
			this.tile[1130].collision = true;

			this.tile[1131] = new Tile();
			this.tile[1131].image = new Image(getClass().getResourceAsStream("/assets/Pmap/131.png"));
			this.tile[1131].collision = true;

			this.tile[1132] = new Tile();
			this.tile[1132].image = new Image(getClass().getResourceAsStream("/assets/Pmap/132.png"));
			this.tile[1132].collision = true;

			this.tile[1133] = new Tile();
			this.tile[1133].image = new Image(getClass().getResourceAsStream("/assets/Pmap/133.png"));
			this.tile[1133].collision = true;

			this.tile[1134] = new Tile();
			this.tile[1134].image = new Image(getClass().getResourceAsStream("/assets/Pmap/134.png"));
			this.tile[1134].collision = true;

			this.tile[1135] = new Tile();
			this.tile[1135].image = new Image(getClass().getResourceAsStream("/assets/Pmap/135.png"));
			this.tile[1135].collision = true;

			this.tile[1136] = new Tile();
			this.tile[1136].image = new Image(getClass().getResourceAsStream("/assets/Pmap/136.png"));
			this.tile[1136].collision = true;

			this.tile[1137] = new Tile();
			this.tile[1137].image = new Image(getClass().getResourceAsStream("/assets/Pmap/137.png"));
			this.tile[1137].collision = true;

			this.tile[1138] = new Tile();
			this.tile[1138].image = new Image(getClass().getResourceAsStream("/assets/Pmap/138.png"));
			this.tile[1138].collision = true;

			this.tile[1139] = new Tile();
			this.tile[1139].image = new Image(getClass().getResourceAsStream("/assets/Pmap/139.png"));
			this.tile[1139].collision = true;

			this.tile[1140] = new Tile();
			this.tile[1140].image = new Image(getClass().getResourceAsStream("/assets/Pmap/140.png"));
			this.tile[1140].collision = true;

			this.tile[1141] = new Tile();
			this.tile[1141].image = new Image(getClass().getResourceAsStream("/assets/Pmap/141.png"));
			this.tile[1141].collision = true;

			this.tile[1142] = new Tile();
			this.tile[1142].image = new Image(getClass().getResourceAsStream("/assets/Pmap/142.png"));
			this.tile[1142].collision = true;

			this.tile[1143] = new Tile();
			this.tile[1143].image = new Image(getClass().getResourceAsStream("/assets/Pmap/143.png"));
			this.tile[1143].collision = true;

			this.tile[1144] = new Tile();
			this.tile[1144].image = new Image(getClass().getResourceAsStream("/assets/Pmap/144.png"));
			this.tile[1144].collision = true;

			this.tile[1145] = new Tile();
			this.tile[1145].image = new Image(getClass().getResourceAsStream("/assets/Pmap/145.png"));
			this.tile[1145].collision = true;

			this.tile[1146] = new Tile();
			this.tile[1146].image = new Image(getClass().getResourceAsStream("/assets/Pmap/146.png"));
			this.tile[1146].collision = true;

			this.tile[1147] = new Tile();
			this.tile[1147].image = new Image(getClass().getResourceAsStream("/assets/Pmap/147.png"));
			this.tile[1147].collision = true;

			this.tile[1148] = new Tile();
			this.tile[1148].image = new Image(getClass().getResourceAsStream("/assets/Pmap/148.png"));
			this.tile[1148].collision = true;

			this.tile[1149] = new Tile();
			this.tile[1149].image = new Image(getClass().getResourceAsStream("/assets/Pmap/149.png"));
			this.tile[1149].collision = true;

			this.tile[1150] = new Tile();
			this.tile[1150].image = new Image(getClass().getResourceAsStream("/assets/Pmap/150.png"));
			this.tile[1150].collision = true;

			this.tile[1151] = new Tile();
			this.tile[1151].image = new Image(getClass().getResourceAsStream("/assets/Pmap/151.png"));
			this.tile[1151].collision = true;

			this.tile[1152] = new Tile();
			this.tile[1152].image = new Image(getClass().getResourceAsStream("/assets/Pmap/152.png"));
			this.tile[1152].collision = true;

			this.tile[1153] = new Tile();
			this.tile[1153].image = new Image(getClass().getResourceAsStream("/assets/Pmap/153.png"));
			this.tile[1153].collision = true;

			this.tile[1154] = new Tile();
			this.tile[1154].image = new Image(getClass().getResourceAsStream("/assets/Pmap/154.png"));
			this.tile[1154].collision = true;

			this.tile[1155] = new Tile();
			this.tile[1155].image = new Image(getClass().getResourceAsStream("/assets/Pmap/155.png"));
			this.tile[1155].collision = true;

			this.tile[1156] = new Tile();
			this.tile[1156].image = new Image(getClass().getResourceAsStream("/assets/Pmap/156.png"));
			this.tile[1156].collision = true;

			this.tile[1157] = new Tile();
			this.tile[1157].image = new Image(getClass().getResourceAsStream("/assets/Pmap/157.png"));
			this.tile[1157].collision = true;

			this.tile[1158] = new Tile();
			this.tile[1158].image = new Image(getClass().getResourceAsStream("/assets/Pmap/158.png"));
			this.tile[1158].collision = true;

			this.tile[1159] = new Tile();
			this.tile[1159].image = new Image(getClass().getResourceAsStream("/assets/Pmap/159.png"));
			this.tile[1159].collision = true;

			this.tile[1160] = new Tile();
			this.tile[1160].image = new Image(getClass().getResourceAsStream("/assets/Pmap/160.png"));
			this.tile[1160].collision = true;

			this.tile[1161] = new Tile();
			this.tile[1161].image = new Image(getClass().getResourceAsStream("/assets/Pmap/161.png"));
			this.tile[1161].collision = true;

			this.tile[1162] = new Tile();
			this.tile[1162].image = new Image(getClass().getResourceAsStream("/assets/Pmap/162.png"));
			this.tile[1162].collision = true;

			this.tile[1163] = new Tile();
			this.tile[1163].image = new Image(getClass().getResourceAsStream("/assets/Pmap/163.png"));
			this.tile[1163].collision = true;

			this.tile[1164] = new Tile();
			this.tile[1164].image = new Image(getClass().getResourceAsStream("/assets/Pmap/164.png"));
			this.tile[1164].collision = true;

			this.tile[1165] = new Tile();
			this.tile[1165].image = new Image(getClass().getResourceAsStream("/assets/Pmap/165.png"));
			this.tile[1165].collision = true;

			this.tile[1166] = new Tile();
			this.tile[1166].image = new Image(getClass().getResourceAsStream("/assets/Pmap/166.png"));
			this.tile[1166].collision = true;

			this.tile[1167] = new Tile();
			this.tile[1167].image = new Image(getClass().getResourceAsStream("/assets/Pmap/167.png"));
			this.tile[1167].collision = true;

			this.tile[1168] = new Tile();
			this.tile[1168].image = new Image(getClass().getResourceAsStream("/assets/Pmap/168.png"));
			this.tile[1168].collision = true;

			this.tile[1169] = new Tile();
			this.tile[1169].image = new Image(getClass().getResourceAsStream("/assets/Pmap/169.png"));
			this.tile[1169].collision = true;

			this.tile[1170] = new Tile();
			this.tile[1170].image = new Image(getClass().getResourceAsStream("/assets/Pmap/170.png"));
			this.tile[1170].collision = true;

			this.tile[1171] = new Tile();
			this.tile[1171].image = new Image(getClass().getResourceAsStream("/assets/Pmap/171.png"));
			this.tile[1171].collision = true;

			this.tile[1172] = new Tile();
			this.tile[1172].image = new Image(getClass().getResourceAsStream("/assets/Pmap/172.png"));

			this.tile[1173] = new Tile();
			this.tile[1173].image = new Image(getClass().getResourceAsStream("/assets/Pmap/173.png"));

			this.tile[1174] = new Tile();
			this.tile[1174].image = new Image(getClass().getResourceAsStream("/assets/Pmap/174.png"));

			this.tile[1175] = new Tile();
			this.tile[1175].image = new Image(getClass().getResourceAsStream("/assets/Pmap/175.png"));

			this.tile[1176] = new Tile();
			this.tile[1176].image = new Image(getClass().getResourceAsStream("/assets/Pmap/176.png"));

			this.tile[1177] = new Tile();
			this.tile[1177].image = new Image(getClass().getResourceAsStream("/assets/Pmap/177.png"));

			this.tile[1178] = new Tile();
			this.tile[1178].image = new Image(getClass().getResourceAsStream("/assets/Pmap/178.png"));

			this.tile[1179] = new Tile();
			this.tile[1179].image = new Image(getClass().getResourceAsStream("/assets/Pmap/179.png"));
			this.tile[1179].collision = true;

			this.tile[1180] = new Tile();
			this.tile[1180].image = new Image(getClass().getResourceAsStream("/assets/Pmap/180.png"));
			this.tile[1180].collision = true;

			this.tile[1181] = new Tile();
			this.tile[1181].image = new Image(getClass().getResourceAsStream("/assets/Pmap/181.png"));
			this.tile[1181].collision = true;

			this.tile[1182] = new Tile();
			this.tile[1182].image = new Image(getClass().getResourceAsStream("/assets/Pmap/182.png"));
			this.tile[1182].collision = true;

			this.tile[1183] = new Tile();
			this.tile[1183].image = new Image(getClass().getResourceAsStream("/assets/Pmap/183.png"));
			this.tile[1183].collision = true;

			this.tile[1184] = new Tile();
			this.tile[1184].image = new Image(getClass().getResourceAsStream("/assets/Pmap/184.png"));
			this.tile[1184].collision = true;

			this.tile[1185] = new Tile();
			this.tile[1185].image = new Image(getClass().getResourceAsStream("/assets/Pmap/185.png"));
			this.tile[1185].collision = true;

			this.tile[1186] = new Tile();
			this.tile[1186].image = new Image(getClass().getResourceAsStream("/assets/Pmap/186.png"));
			this.tile[1186].collision = true;

			this.tile[1187] = new Tile();
			this.tile[1187].image = new Image(getClass().getResourceAsStream("/assets/Pmap/187.png"));
			this.tile[1187].collision = true;

			this.tile[1188] = new Tile();
			this.tile[1188].image = new Image(getClass().getResourceAsStream("/assets/Pmap/188.png"));
			this.tile[1188].collision = true;

			this.tile[1189] = new Tile();
			this.tile[1189].image = new Image(getClass().getResourceAsStream("/assets/Pmap/189.png"));
			this.tile[1189].collision = true;

			this.tile[1190] = new Tile();
			this.tile[1190].image = new Image(getClass().getResourceAsStream("/assets/Pmap/190.png"));
			this.tile[1190].collision = true;

			this.tile[1191] = new Tile();
			this.tile[1191].image = new Image(getClass().getResourceAsStream("/assets/Pmap/191.png"));
			this.tile[1191].collision = true;

			this.tile[1192] = new Tile();
			this.tile[1192].image = new Image(getClass().getResourceAsStream("/assets/Pmap/192.png"));
			this.tile[1192].collision = true;

			this.tile[1193] = new Tile();
			this.tile[1193].image = new Image(getClass().getResourceAsStream("/assets/Pmap/193.png"));
			this.tile[1193].collision = true;

			this.tile[1194] = new Tile();
			this.tile[1194].image = new Image(getClass().getResourceAsStream("/assets/Pmap/194.png"));
			this.tile[1194].collision = true;

			this.tile[1195] = new Tile();
			this.tile[1195].image = new Image(getClass().getResourceAsStream("/assets/Pmap/195.png"));
			this.tile[1195].collision = true;

			this.tile[1196] = new Tile();
			this.tile[1196].image = new Image(getClass().getResourceAsStream("/assets/Pmap/196.png"));
			this.tile[1196].collision = true;

			this.tile[1197] = new Tile();
			this.tile[1197].image = new Image(getClass().getResourceAsStream("/assets/Pmap/197.png"));
			this.tile[1197].collision = true;

			this.tile[1198] = new Tile();
			this.tile[1198].image = new Image(getClass().getResourceAsStream("/assets/Pmap/198.png"));
			this.tile[1198].collision = true;

			this.tile[1199] = new Tile();
			this.tile[1199].image = new Image(getClass().getResourceAsStream("/assets/Pmap/199.png"));
			this.tile[1199].collision = true;

			this.tile[1200] = new Tile();
			this.tile[1200].image = new Image(getClass().getResourceAsStream("/assets/Pmap/200.png"));
			this.tile[1200].collision = true;

			this.tile[1201] = new Tile();
			this.tile[1201].image = new Image(getClass().getResourceAsStream("/assets/Pmap/201.png"));
			this.tile[1201].collision = true;

			this.tile[1202] = new Tile();
			this.tile[1202].image = new Image(getClass().getResourceAsStream("/assets/Pmap/202.png"));
			this.tile[1202].collision = true;

			this.tile[1203] = new Tile();
			this.tile[1203].image = new Image(getClass().getResourceAsStream("/assets/Pmap/203.png"));
			this.tile[1203].collision = true;

			this.tile[1204] = new Tile();
			this.tile[1204].image = new Image(getClass().getResourceAsStream("/assets/Pmap/204.png"));
			this.tile[1204].collision = true;

			this.tile[1205] = new Tile();
			this.tile[1205].image = new Image(getClass().getResourceAsStream("/assets/Pmap/205.png"));
			this.tile[1205].collision = true;

			this.tile[1206] = new Tile();
			this.tile[1206].image = new Image(getClass().getResourceAsStream("/assets/Pmap/206.png"));
			this.tile[1206].collision = true;

			this.tile[1207] = new Tile();
			this.tile[1207].image = new Image(getClass().getResourceAsStream("/assets/Pmap/207.png"));
			this.tile[1207].collision = true;

			this.tile[1208] = new Tile();
			this.tile[1208].image = new Image(getClass().getResourceAsStream("/assets/Pmap/208.png"));
			this.tile[1208].collision = true;

			this.tile[1209] = new Tile();
			this.tile[1209].image = new Image(getClass().getResourceAsStream("/assets/Pmap/209.png"));
			this.tile[1209].collision = true;

			this.tile[1210] = new Tile();
			this.tile[1210].image = new Image(getClass().getResourceAsStream("/assets/Pmap/210.png"));
			this.tile[1210].collision = true;

			this.tile[1211] = new Tile();
			this.tile[1211].image = new Image(getClass().getResourceAsStream("/assets/Pmap/211.png"));
			this.tile[1211].collision = true;

			this.tile[1212] = new Tile();
			this.tile[1212].image = new Image(getClass().getResourceAsStream("/assets/Pmap/212.png"));
			this.tile[1212].collision = true;

			this.tile[1213] = new Tile();
			this.tile[1213].image = new Image(getClass().getResourceAsStream("/assets/Pmap/213.png"));
			this.tile[1213].collision = true;

			this.tile[1214] = new Tile();
			this.tile[1214].image = new Image(getClass().getResourceAsStream("/assets/Pmap/214.png"));
			this.tile[1214].collision = true;

			this.tile[1215] = new Tile();
			this.tile[1215].image = new Image(getClass().getResourceAsStream("/assets/Pmap/215.png"));
			this.tile[1215].collision = true;

			this.tile[1216] = new Tile();
			this.tile[1216].image = new Image(getClass().getResourceAsStream("/assets/Pmap/216.png"));
			this.tile[1216].collision = true;

			this.tile[1217] = new Tile();
			this.tile[1217].image = new Image(getClass().getResourceAsStream("/assets/Pmap/217.png"));
			this.tile[1217].collision = true;

			this.tile[1218] = new Tile();
			this.tile[1218].image = new Image(getClass().getResourceAsStream("/assets/Pmap/218.png"));
			this.tile[1218].collision = true;

			this.tile[1219] = new Tile();
			this.tile[1219].image = new Image(getClass().getResourceAsStream("/assets/Pmap/219.png"));
			this.tile[1219].collision = true;

			this.tile[1220] = new Tile();
			this.tile[1220].image = new Image(getClass().getResourceAsStream("/assets/Pmap/220.png"));
			this.tile[1220].collision = true;

			this.tile[1221] = new Tile();
			this.tile[1221].image = new Image(getClass().getResourceAsStream("/assets/Pmap/221.png"));
			this.tile[1221].collision = true;

			this.tile[1222] = new Tile();
			this.tile[1222].image = new Image(getClass().getResourceAsStream("/assets/Pmap/222.png"));
			this.tile[1222].collision = true;

			this.tile[1223] = new Tile();
			this.tile[1223].image = new Image(getClass().getResourceAsStream("/assets/Pmap/223.png"));
			this.tile[1223].collision = true;

			this.tile[1224] = new Tile();
			this.tile[1224].image = new Image(getClass().getResourceAsStream("/assets/Pmap/224.png"));
			this.tile[1224].collision = true;

			this.tile[1225] = new Tile();
			this.tile[1225].image = new Image(getClass().getResourceAsStream("/assets/Pmap/225.png"));
			this.tile[1225].collision = true;

			this.tile[1226] = new Tile();
			this.tile[1226].image = new Image(getClass().getResourceAsStream("/assets/Pmap/226.png"));
			this.tile[1226].collision = true;

			this.tile[1227] = new Tile();
			this.tile[1227].image = new Image(getClass().getResourceAsStream("/assets/Pmap/227.png"));
			this.tile[1227].collision = true;

			this.tile[1228] = new Tile();
			this.tile[1228].image = new Image(getClass().getResourceAsStream("/assets/Pmap/228.png"));
			this.tile[1228].collision = true;

			this.tile[1229] = new Tile();
			this.tile[1229].image = new Image(getClass().getResourceAsStream("/assets/Pmap/229.png"));
			this.tile[1229].collision = true;

			this.tile[1230] = new Tile();
			this.tile[1230].image = new Image(getClass().getResourceAsStream("/assets/Pmap/230.png"));
			this.tile[1230].collision = true;

			this.tile[1231] = new Tile();
			this.tile[1231].image = new Image(getClass().getResourceAsStream("/assets/Pmap/231.png"));
			this.tile[1231].collision = true;

			this.tile[1232] = new Tile();
			this.tile[1232].image = new Image(getClass().getResourceAsStream("/assets/Pmap/232.png"));
			this.tile[1232].collision = true;

			this.tile[1233] = new Tile();
			this.tile[1233].image = new Image(getClass().getResourceAsStream("/assets/Pmap/233.png"));
			this.tile[1233].collision = true;

			this.tile[1234] = new Tile();
			this.tile[1234].image = new Image(getClass().getResourceAsStream("/assets/Pmap/234.png"));
			this.tile[1234].collision = true;

			this.tile[1235] = new Tile();
			this.tile[1235].image = new Image(getClass().getResourceAsStream("/assets/Pmap/235.png"));
			this.tile[1235].collision = true;

			this.tile[1236] = new Tile();
			this.tile[1236].image = new Image(getClass().getResourceAsStream("/assets/Pmap/236.png"));
			this.tile[1236].collision = true;

			this.tile[1237] = new Tile();
			this.tile[1237].image = new Image(getClass().getResourceAsStream("/assets/Pmap/237.png"));
			this.tile[1237].collision = true;

			this.tile[1238] = new Tile();
			this.tile[1238].image = new Image(getClass().getResourceAsStream("/assets/Pmap/238.png"));
			this.tile[1238].collision = true;

			this.tile[1239] = new Tile();
			this.tile[1239].image = new Image(getClass().getResourceAsStream("/assets/Pmap/239.png"));
			this.tile[1239].collision = true;

			this.tile[1240] = new Tile();
			this.tile[1240].image = new Image(getClass().getResourceAsStream("/assets/Pmap/240.png"));
			this.tile[1240].collision = true;

			this.tile[1241] = new Tile();
			this.tile[1241].image = new Image(getClass().getResourceAsStream("/assets/Pmap/241.png"));
			this.tile[1241].collision = true;

			this.tile[1242] = new Tile();
			this.tile[1242].image = new Image(getClass().getResourceAsStream("/assets/Pmap/242.png"));
			this.tile[1242].collision = true;

			this.tile[1243] = new Tile();
			this.tile[1243].image = new Image(getClass().getResourceAsStream("/assets/Pmap/243.png"));
			this.tile[1243].collision = true;

			this.tile[1244] = new Tile();
			this.tile[1244].image = new Image(getClass().getResourceAsStream("/assets/Pmap/244.png"));
			this.tile[1244].collision = true;

			this.tile[1245] = new Tile();
			this.tile[1245].image = new Image(getClass().getResourceAsStream("/assets/Pmap/245.png"));
			this.tile[1245].collision = true;

			this.tile[1246] = new Tile();
			this.tile[1246].image = new Image(getClass().getResourceAsStream("/assets/Pmap/246.png"));
			this.tile[1246].collision = true;

			this.tile[1247] = new Tile();
			this.tile[1247].image = new Image(getClass().getResourceAsStream("/assets/Pmap/247.png"));
			this.tile[1247].collision = true;

			this.tile[1248] = new Tile();
			this.tile[1248].image = new Image(getClass().getResourceAsStream("/assets/Pmap/248.png"));
			this.tile[1248].collision = true;

			this.tile[1249] = new Tile();
			this.tile[1249].image = new Image(getClass().getResourceAsStream("/assets/Pmap/249.png"));
			this.tile[1249].collision = true;

			this.tile[1250] = new Tile();
			this.tile[1250].image = new Image(getClass().getResourceAsStream("/assets/Pmap/250.png"));
			this.tile[1250].collision = true;

			this.tile[1251] = new Tile();
			this.tile[1251].image = new Image(getClass().getResourceAsStream("/assets/Pmap/251.png"));
			this.tile[1251].collision = true;

			this.tile[1252] = new Tile();
			this.tile[1252].image = new Image(getClass().getResourceAsStream("/assets/Pmap/252.png"));

			this.tile[1253] = new Tile();
			this.tile[1253].image = new Image(getClass().getResourceAsStream("/assets/Pmap/253.png"));

			this.tile[1254] = new Tile();
			this.tile[1254].image = new Image(getClass().getResourceAsStream("/assets/Pmap/254.png"));

			this.tile[1255] = new Tile();
			this.tile[1255].image = new Image(getClass().getResourceAsStream("/assets/Pmap/255.png"));
			this.tile[1255].collision = true;

			this.tile[1256] = new Tile();
			this.tile[1256].image = new Image(getClass().getResourceAsStream("/assets/Pmap/256.png"));
			this.tile[1256].collision = true;

			this.tile[1257] = new Tile();
			this.tile[1257].image = new Image(getClass().getResourceAsStream("/assets/Pmap/257.png"));
			this.tile[1257].collision = true;

			this.tile[1258] = new Tile();
			this.tile[1258].image = new Image(getClass().getResourceAsStream("/assets/Pmap/258.png"));
			this.tile[1258].collision = true;

			this.tile[1259] = new Tile();
			this.tile[1259].image = new Image(getClass().getResourceAsStream("/assets/Pmap/259.png"));

			this.tile[1260] = new Tile();
			this.tile[1260].image = new Image(getClass().getResourceAsStream("/assets/Pmap/260.png"));

			this.tile[1261] = new Tile();
			this.tile[1261].image = new Image(getClass().getResourceAsStream("/assets/Pmap/261.png"));

			this.tile[1262] = new Tile();
			this.tile[1262].image = new Image(getClass().getResourceAsStream("/assets/Pmap/262.png"));
			this.tile[1262].collision = true;

			this.tile[1263] = new Tile();
			this.tile[1263].image = new Image(getClass().getResourceAsStream("/assets/Pmap/263.png"));
			this.tile[1263].collision = true;

			this.tile[1264] = new Tile();
			this.tile[1264].image = new Image(getClass().getResourceAsStream("/assets/Pmap/264.png"));
			this.tile[1264].collision = true;

			this.tile[1265] = new Tile();
			this.tile[1265].image = new Image(getClass().getResourceAsStream("/assets/Pmap/265.png"));

			this.tile[1266] = new Tile();
			this.tile[1266].image = new Image(getClass().getResourceAsStream("/assets/Pmap/266.png"));

			this.tile[1267] = new Tile();
			this.tile[1267].image = new Image(getClass().getResourceAsStream("/assets/Pmap/267.png"));

			this.tile[1268] = new Tile();
			this.tile[1268].image = new Image(getClass().getResourceAsStream("/assets/Pmap/268.png"));

			this.tile[1269] = new Tile();
			this.tile[1269].image = new Image(getClass().getResourceAsStream("/assets/Pmap/269.png"));

			this.tile[1270] = new Tile();
			this.tile[1270].image = new Image(getClass().getResourceAsStream("/assets/Pmap/270.png"));
			this.tile[1270].collision = true;

			this.tile[1271] = new Tile();
			this.tile[1271].image = new Image(getClass().getResourceAsStream("/assets/Pmap/271.png"));
			this.tile[1271].collision = true;

			this.tile[1272] = new Tile();
			this.tile[1272].image = new Image(getClass().getResourceAsStream("/assets/Pmap/272.png"));
			this.tile[1272].collision = true;

			this.tile[1273] = new Tile();
			this.tile[1273].image = new Image(getClass().getResourceAsStream("/assets/Pmap/273.png"));

			this.tile[1274] = new Tile();
			this.tile[1274].image = new Image(getClass().getResourceAsStream("/assets/Pmap/274.png"));

			this.tile[1275] = new Tile();
			this.tile[1275].image = new Image(getClass().getResourceAsStream("/assets/Pmap/275.png"));

			this.tile[1276] = new Tile();
			this.tile[1276].image = new Image(getClass().getResourceAsStream("/assets/Pmap/276.png"));

			this.tile[1277] = new Tile();
			this.tile[1277].image = new Image(getClass().getResourceAsStream("/assets/Pmap/277.png"));

			this.tile[1278] = new Tile();
			this.tile[1278].image = new Image(getClass().getResourceAsStream("/assets/Pmap/278.png"));
			this.tile[1278].collision = true;

			this.tile[1279] = new Tile();
			this.tile[1279].image = new Image(getClass().getResourceAsStream("/assets/Pmap/279.png"));
			this.tile[1279].collision = true;

			this.tile[1280] = new Tile();
			this.tile[1280].image = new Image(getClass().getResourceAsStream("/assets/Pmap/280.png"));
			this.tile[1280].collision = true;

			this.tile[1281] = new Tile();
			this.tile[1281].image = new Image(getClass().getResourceAsStream("/assets/Pmap/281.png"));

			this.tile[1282] = new Tile();
			this.tile[1282].image = new Image(getClass().getResourceAsStream("/assets/Pmap/282.png"));

			this.tile[1283] = new Tile();
			this.tile[1283].image = new Image(getClass().getResourceAsStream("/assets/Pmap/283.png"));

			this.tile[1284] = new Tile();
			this.tile[1284].image = new Image(getClass().getResourceAsStream("/assets/Pmap/284.png"));

			this.tile[1285] = new Tile();
			this.tile[1285].image = new Image(getClass().getResourceAsStream("/assets/Pmap/285.png"));

			this.tile[1286] = new Tile();
			this.tile[1286].image = new Image(getClass().getResourceAsStream("/assets/Pmap/286.png"));
			this.tile[1286].collision = true;

			this.tile[1287] = new Tile();
			this.tile[1287].image = new Image(getClass().getResourceAsStream("/assets/Pmap/287.png"));
			this.tile[1287].collision = true;

			this.tile[1288] = new Tile();
			this.tile[1288].image = new Image(getClass().getResourceAsStream("/assets/Pmap/288.png"));

			this.tile[1289] = new Tile();
			this.tile[1289].image = new Image(getClass().getResourceAsStream("/assets/Pmap/289.png"));

			this.tile[1290] = new Tile();
			this.tile[1290].image = new Image(getClass().getResourceAsStream("/assets/Pmap/290.png"));

			this.tile[1291] = new Tile();
			this.tile[1291].image = new Image(getClass().getResourceAsStream("/assets/Pmap/291.png"));

			this.tile[1292] = new Tile();
			this.tile[1292].image = new Image(getClass().getResourceAsStream("/assets/Pmap/292.png"));

			this.tile[1293] = new Tile();
			this.tile[1293].image = new Image(getClass().getResourceAsStream("/assets/Pmap/293.png"));
			this.tile[1293].collision = true;

			this.tile[1294] = new Tile();
			this.tile[1294].image = new Image(getClass().getResourceAsStream("/assets/Pmap/294.png"));
			this.tile[1294].collision = true;

			this.tile[1295] = new Tile();
			this.tile[1295].image = new Image(getClass().getResourceAsStream("/assets/Pmap/295.png"));
			this.tile[1295].collision = true;

			this.tile[1296] = new Tile();
			this.tile[1296].image = new Image(getClass().getResourceAsStream("/assets/Pmap/296.png"));

			this.tile[1297] = new Tile();
			this.tile[1297].image = new Image(getClass().getResourceAsStream("/assets/Pmap/297.png"));

			this.tile[1298] = new Tile();
			this.tile[1298].image = new Image(getClass().getResourceAsStream("/assets/Pmap/298.png"));

			this.tile[1299] = new Tile();
			this.tile[1299].image = new Image(getClass().getResourceAsStream("/assets/Pmap/299.png"));

			this.tile[1300] = new Tile();
			this.tile[1300].image = new Image(getClass().getResourceAsStream("/assets/Pmap/300.png"));
			this.tile[1300].collision = true;

			this.tile[1301] = new Tile();
			this.tile[1301].image = new Image(getClass().getResourceAsStream("/assets/Pmap/301.png"));
			this.tile[1301].collision = true;

			this.tile[1302] = new Tile();
			this.tile[1302].image = new Image(getClass().getResourceAsStream("/assets/Pmap/302.png"));

			this.tile[1303] = new Tile();
			this.tile[1303].image = new Image(getClass().getResourceAsStream("/assets/Pmap/303.png"));

			this.tile[1304] = new Tile();
			this.tile[1304].image = new Image(getClass().getResourceAsStream("/assets/Pmap/304.png"));

			this.tile[1305] = new Tile();
			this.tile[1305].image = new Image(getClass().getResourceAsStream("/assets/Pmap/305.png"));

			this.tile[1306] = new Tile();
			this.tile[1306].image = new Image(getClass().getResourceAsStream("/assets/Pmap/306.png"));

			this.tile[1307] = new Tile();
			this.tile[1307].image = new Image(getClass().getResourceAsStream("/assets/Pmap/307.png"));

			this.tile[1308] = new Tile();
			this.tile[1308].image = new Image(getClass().getResourceAsStream("/assets/Pmap/308.png"));
			this.tile[1308].collision = true;

			this.tile[1309] = new Tile();
			this.tile[1309].image = new Image(getClass().getResourceAsStream("/assets/Pmap/309.png"));

			this.tile[1310] = new Tile();
			this.tile[1310].image = new Image(getClass().getResourceAsStream("/assets/Pmap/310.png"));

			this.tile[1311] = new Tile();
			this.tile[1311].image = new Image(getClass().getResourceAsStream("/assets/Pmap/311.png"));

			this.tile[1312] = new Tile();
			this.tile[1312].image = new Image(getClass().getResourceAsStream("/assets/Pmap/312.png"));

			this.tile[1313] = new Tile();
			this.tile[1313].image = new Image(getClass().getResourceAsStream("/assets/Pmap/313.png"));

			this.tile[1314] = new Tile();
			this.tile[1314].image = new Image(getClass().getResourceAsStream("/assets/Pmap/314.png"));

			this.tile[1315] = new Tile();
			this.tile[1315].image = new Image(getClass().getResourceAsStream("/assets/Pmap/315.png"));

			this.tile[1316] = new Tile();
			this.tile[1316].image = new Image(getClass().getResourceAsStream("/assets/Pmap/316.png"));

			this.tile[1317] = new Tile();
			this.tile[1317].image = new Image(getClass().getResourceAsStream("/assets/Pmap/317.png"));

			this.tile[1318] = new Tile();
			this.tile[1318].image = new Image(getClass().getResourceAsStream("/assets/Pmap/318.png"));

			this.tile[1319] = new Tile();
			this.tile[1319].image = new Image(getClass().getResourceAsStream("/assets/Pmap/319.png"));

			this.tile[1320] = new Tile();
			this.tile[1320].image = new Image(getClass().getResourceAsStream("/assets/Pmap/320.png"));

			this.tile[1321] = new Tile();
			this.tile[1321].image = new Image(getClass().getResourceAsStream("/assets/Pmap/321.png"));

			this.tile[1322] = new Tile();
			this.tile[1322].image = new Image(getClass().getResourceAsStream("/assets/Pmap/322.png"));

			this.tile[1323] = new Tile();
			this.tile[1323].image = new Image(getClass().getResourceAsStream("/assets/Pmap/323.png"));

			this.tile[1324] = new Tile();
			this.tile[1324].image = new Image(getClass().getResourceAsStream("/assets/Pmap/324.png"));

			this.tile[1325] = new Tile();
			this.tile[1325].image = new Image(getClass().getResourceAsStream("/assets/Pmap/325.png"));

			this.tile[1326] = new Tile();
			this.tile[1326].image = new Image(getClass().getResourceAsStream("/assets/Pmap/326.png"));

			this.tile[1327] = new Tile();
			this.tile[1327].image = new Image(getClass().getResourceAsStream("/assets/Pmap/327.png"));

			this.tile[1328] = new Tile();
			this.tile[1328].image = new Image(getClass().getResourceAsStream("/assets/Pmap/328.png"));

			this.tile[1329] = new Tile();
			this.tile[1329].image = new Image(getClass().getResourceAsStream("/assets/Pmap/329.png"));

			this.tile[1330] = new Tile();
			this.tile[1330].image = new Image(getClass().getResourceAsStream("/assets/Pmap/330.png"));

			this.tile[1331] = new Tile();
			this.tile[1331].image = new Image(getClass().getResourceAsStream("/assets/Pmap/331.png"));

			this.tile[1332] = new Tile();
			this.tile[1332].image = new Image(getClass().getResourceAsStream("/assets/Pmap/332.png"));

			this.tile[1333] = new Tile();
			this.tile[1333].image = new Image(getClass().getResourceAsStream("/assets/Pmap/333.png"));

			this.tile[1334] = new Tile();
			this.tile[1334].image = new Image(getClass().getResourceAsStream("/assets/Pmap/334.png"));

			this.tile[1335] = new Tile();
			this.tile[1335].image = new Image(getClass().getResourceAsStream("/assets/Pmap/335.png"));

			this.tile[1336] = new Tile();
			this.tile[1336].image = new Image(getClass().getResourceAsStream("/assets/Pmap/336.png"));

			this.tile[1337] = new Tile();
			this.tile[1337].image = new Image(getClass().getResourceAsStream("/assets/Pmap/337.png"));

			this.tile[1338] = new Tile();
			this.tile[1338].image = new Image(getClass().getResourceAsStream("/assets/Pmap/338.png"));

			this.tile[1339] = new Tile();
			this.tile[1339].image = new Image(getClass().getResourceAsStream("/assets/Pmap/339.png"));

			this.tile[1340] = new Tile();
			this.tile[1340].image = new Image(getClass().getResourceAsStream("/assets/Pmap/340.png"));

			this.tile[1341] = new Tile();
			this.tile[1341].image = new Image(getClass().getResourceAsStream("/assets/Pmap/341.png"));

			this.tile[1342] = new Tile();
			this.tile[1342].image = new Image(getClass().getResourceAsStream("/assets/Pmap/342.png"));

			this.tile[1343] = new Tile();
			this.tile[1343].image = new Image(getClass().getResourceAsStream("/assets/Pmap/343.png"));
			this.tile[1343].collision = true;
			
			this.tile[1344] = new Tile();
			this.tile[1344].image = new Image(getClass().getResourceAsStream("/assets/Pmap/344.png"));

			this.tile[1345] = new Tile();
			this.tile[1345].image = new Image(getClass().getResourceAsStream("/assets/Pmap/345.png"));

			this.tile[1346] = new Tile();
			this.tile[1346].image = new Image(getClass().getResourceAsStream("/assets/Pmap/346.png"));

			this.tile[1347] = new Tile();
			this.tile[1347].image = new Image(getClass().getResourceAsStream("/assets/Pmap/347.png"));

			this.tile[1348] = new Tile();
			this.tile[1348].image = new Image(getClass().getResourceAsStream("/assets/Pmap/348.png"));

			this.tile[1349] = new Tile();
			this.tile[1349].image = new Image(getClass().getResourceAsStream("/assets/Pmap/349.png"));

			this.tile[1350] = new Tile();
			this.tile[1350].image = new Image(getClass().getResourceAsStream("/assets/Pmap/350.png"));
			this.tile[1350].collision = true;

			this.tile[1351] = new Tile();
			this.tile[1351].image = new Image(getClass().getResourceAsStream("/assets/Pmap/351.png"));
			this.tile[1351].collision = true;

			this.tile[1352] = new Tile();
			this.tile[1352].image = new Image(getClass().getResourceAsStream("/assets/Pmap/352.png"));

			this.tile[1353] = new Tile();
			this.tile[1353].image = new Image(getClass().getResourceAsStream("/assets/Pmap/353.png"));

			this.tile[1354] = new Tile();
			this.tile[1354].image = new Image(getClass().getResourceAsStream("/assets/Pmap/354.png"));

			this.tile[1355] = new Tile();
			this.tile[1355].image = new Image(getClass().getResourceAsStream("/assets/Pmap/355.png"));

			this.tile[1356] = new Tile();
			this.tile[1356].image = new Image(getClass().getResourceAsStream("/assets/Pmap/356.png"));

			this.tile[1357] = new Tile();
			this.tile[1357].image = new Image(getClass().getResourceAsStream("/assets/Pmap/357.png"));

			this.tile[1358] = new Tile();
			this.tile[1358].image = new Image(getClass().getResourceAsStream("/assets/Pmap/358.png"));
			this.tile[1358].collision = true;

			this.tile[1359] = new Tile();
			this.tile[1359].image = new Image(getClass().getResourceAsStream("/assets/Pmap/359.png"));

			this.tile[1360] = new Tile();
			this.tile[1360].image = new Image(getClass().getResourceAsStream("/assets/Pmap/360.png"));

			this.tile[1361] = new Tile();
			this.tile[1361].image = new Image(getClass().getResourceAsStream("/assets/Pmap/361.png"));

			this.tile[1362] = new Tile();
			this.tile[1362].image = new Image(getClass().getResourceAsStream("/assets/Pmap/362.png"));

			this.tile[1363] = new Tile();
			this.tile[1363].image = new Image(getClass().getResourceAsStream("/assets/Pmap/363.png"));

			this.tile[1364] = new Tile();
			this.tile[1364].image = new Image(getClass().getResourceAsStream("/assets/Pmap/364.png"));

			this.tile[1365] = new Tile();
			this.tile[1365].image = new Image(getClass().getResourceAsStream("/assets/Pmap/365.png"));

			this.tile[1366] = new Tile();
			this.tile[1366].image = new Image(getClass().getResourceAsStream("/assets/Pmap/366.png"));

			this.tile[1367] = new Tile();
			this.tile[1367].image = new Image(getClass().getResourceAsStream("/assets/Pmap/367.png"));

			this.tile[1368] = new Tile();
			this.tile[1368].image = new Image(getClass().getResourceAsStream("/assets/Pmap/368.png"));

			this.tile[1369] = new Tile();
			this.tile[1369].image = new Image(getClass().getResourceAsStream("/assets/Pmap/369.png"));

			this.tile[1370] = new Tile();
			this.tile[1370].image = new Image(getClass().getResourceAsStream("/assets/Pmap/370.png"));

			this.tile[1371] = new Tile();
			this.tile[1371].image = new Image(getClass().getResourceAsStream("/assets/Pmap/371.png"));

			this.tile[1372] = new Tile();
			this.tile[1372].image = new Image(getClass().getResourceAsStream("/assets/Pmap/372.png"));

			this.tile[1373] = new Tile();
			this.tile[1373].image = new Image(getClass().getResourceAsStream("/assets/Pmap/373.png"));

			this.tile[1374] = new Tile();
			this.tile[1374].image = new Image(getClass().getResourceAsStream("/assets/Pmap/374.png"));

			this.tile[1375] = new Tile();
			this.tile[1375].image = new Image(getClass().getResourceAsStream("/assets/Pmap/375.png"));

			this.tile[1376] = new Tile();
			this.tile[1376].image = new Image(getClass().getResourceAsStream("/assets/Pmap/376.png"));

			this.tile[1377] = new Tile();
			this.tile[1377].image = new Image(getClass().getResourceAsStream("/assets/Pmap/377.png"));

			this.tile[1378] = new Tile();
			this.tile[1378].image = new Image(getClass().getResourceAsStream("/assets/Pmap/378.png"));

			this.tile[1379] = new Tile();
			this.tile[1379].image = new Image(getClass().getResourceAsStream("/assets/Pmap/379.png"));

			this.tile[1380] = new Tile();
			this.tile[1380].image = new Image(getClass().getResourceAsStream("/assets/Pmap/380.png"));

			this.tile[1381] = new Tile();
			this.tile[1381].image = new Image(getClass().getResourceAsStream("/assets/Pmap/381.png"));

			this.tile[1382] = new Tile();
			this.tile[1382].image = new Image(getClass().getResourceAsStream("/assets/Pmap/382.png"));

			this.tile[1383] = new Tile();
			this.tile[1383].image = new Image(getClass().getResourceAsStream("/assets/Pmap/383.png"));

			this.tile[1384] = new Tile();
			this.tile[1384].image = new Image(getClass().getResourceAsStream("/assets/Pmap/384.png"));

			this.tile[1385] = new Tile();
			this.tile[1385].image = new Image(getClass().getResourceAsStream("/assets/Pmap/385.png"));

			this.tile[1386] = new Tile();
			this.tile[1386].image = new Image(getClass().getResourceAsStream("/assets/Pmap/386.png"));

			this.tile[1387] = new Tile();
			this.tile[1387].image = new Image(getClass().getResourceAsStream("/assets/Pmap/387.png"));

			this.tile[1388] = new Tile();
			this.tile[1388].image = new Image(getClass().getResourceAsStream("/assets/Pmap/388.png"));

			this.tile[1389] = new Tile();
			this.tile[1389].image = new Image(getClass().getResourceAsStream("/assets/Pmap/389.png"));

			this.tile[1390] = new Tile();
			this.tile[1390].image = new Image(getClass().getResourceAsStream("/assets/Pmap/390.png"));

			this.tile[1391] = new Tile();
			this.tile[1391].image = new Image(getClass().getResourceAsStream("/assets/Pmap/391.png"));

			this.tile[1392] = new Tile();
			this.tile[1392].image = new Image(getClass().getResourceAsStream("/assets/Pmap/392.png"));

			this.tile[1393] = new Tile();
			this.tile[1393].image = new Image(getClass().getResourceAsStream("/assets/Pmap/393.png"));
			this.tile[1393].collision = true;
			this.tile[1394] = new Tile();
			this.tile[1394].image = new Image(getClass().getResourceAsStream("/assets/Pmap/394.png"));

			this.tile[1395] = new Tile();
			this.tile[1395].image = new Image(getClass().getResourceAsStream("/assets/Pmap/395.png"));

			this.tile[1396] = new Tile();
			this.tile[1396].image = new Image(getClass().getResourceAsStream("/assets/Pmap/396.png"));

			this.tile[1397] = new Tile();
			this.tile[1397].image = new Image(getClass().getResourceAsStream("/assets/Pmap/397.png"));

			this.tile[1398] = new Tile();
			this.tile[1398].image = new Image(getClass().getResourceAsStream("/assets/Pmap/398.png"));

			this.tile[1399] = new Tile();
			this.tile[1399].image = new Image(getClass().getResourceAsStream("/assets/Pmap/399.png"));

			this.tile[1400] = new Tile();
			this.tile[1400].image = new Image(getClass().getResourceAsStream("/assets/Pmap/400.png"));
			this.tile[1400].collision = true;

			this.tile[1401] = new Tile();
			this.tile[1401].image = new Image(getClass().getResourceAsStream("/assets/Pmap/401.png"));
			this.tile[1401].collision = true;

			this.tile[1402] = new Tile();
			this.tile[1402].image = new Image(getClass().getResourceAsStream("/assets/Pmap/402.png"));

			this.tile[1403] = new Tile();
			this.tile[1403].image = new Image(getClass().getResourceAsStream("/assets/Pmap/403.png"));

			this.tile[1404] = new Tile();
			this.tile[1404].image = new Image(getClass().getResourceAsStream("/assets/Pmap/404.png"));

			this.tile[1405] = new Tile();
			this.tile[1405].image = new Image(getClass().getResourceAsStream("/assets/Pmap/405.png"));

			this.tile[1406] = new Tile();
			this.tile[1406].image = new Image(getClass().getResourceAsStream("/assets/Pmap/406.png"));

			this.tile[1407] = new Tile();
			this.tile[1407].image = new Image(getClass().getResourceAsStream("/assets/Pmap/407.png"));

			this.tile[1408] = new Tile();
			this.tile[1408].image = new Image(getClass().getResourceAsStream("/assets/Pmap/408.png"));
			this.tile[1408].collision = true;

			this.tile[1409] = new Tile();
			this.tile[1409].image = new Image(getClass().getResourceAsStream("/assets/Pmap/409.png"));

			this.tile[1410] = new Tile();
			this.tile[1410].image = new Image(getClass().getResourceAsStream("/assets/Pmap/410.png"));

			this.tile[1411] = new Tile();
			this.tile[1411].image = new Image(getClass().getResourceAsStream("/assets/Pmap/411.png"));

			this.tile[1412] = new Tile();
			this.tile[1412].image = new Image(getClass().getResourceAsStream("/assets/Pmap/412.png"));

			this.tile[1413] = new Tile();
			this.tile[1413].image = new Image(getClass().getResourceAsStream("/assets/Pmap/413.png"));

			this.tile[1414] = new Tile();
			this.tile[1414].image = new Image(getClass().getResourceAsStream("/assets/Pmap/414.png"));

			this.tile[1415] = new Tile();
			this.tile[1415].image = new Image(getClass().getResourceAsStream("/assets/Pmap/415.png"));

			this.tile[1416] = new Tile();
			this.tile[1416].image = new Image(getClass().getResourceAsStream("/assets/Pmap/416.png"));

			this.tile[1417] = new Tile();
			this.tile[1417].image = new Image(getClass().getResourceAsStream("/assets/Pmap/417.png"));

			this.tile[1418] = new Tile();
			this.tile[1418].image = new Image(getClass().getResourceAsStream("/assets/Pmap/418.png"));

			this.tile[1419] = new Tile();
			this.tile[1419].image = new Image(getClass().getResourceAsStream("/assets/Pmap/419.png"));

			this.tile[1420] = new Tile();
			this.tile[1420].image = new Image(getClass().getResourceAsStream("/assets/Pmap/420.png"));

			this.tile[1421] = new Tile();
			this.tile[1421].image = new Image(getClass().getResourceAsStream("/assets/Pmap/421.png"));

			this.tile[1422] = new Tile();
			this.tile[1422].image = new Image(getClass().getResourceAsStream("/assets/Pmap/422.png"));

			this.tile[1423] = new Tile();
			this.tile[1423].image = new Image(getClass().getResourceAsStream("/assets/Pmap/423.png"));

			this.tile[1424] = new Tile();
			this.tile[1424].image = new Image(getClass().getResourceAsStream("/assets/Pmap/424.png"));

			this.tile[1425] = new Tile();
			this.tile[1425].image = new Image(getClass().getResourceAsStream("/assets/Pmap/425.png"));

			this.tile[1426] = new Tile();
			this.tile[1426].image = new Image(getClass().getResourceAsStream("/assets/Pmap/426.png"));

			this.tile[1427] = new Tile();
			this.tile[1427].image = new Image(getClass().getResourceAsStream("/assets/Pmap/427.png"));

			this.tile[1428] = new Tile();
			this.tile[1428].image = new Image(getClass().getResourceAsStream("/assets/Pmap/428.png"));

			this.tile[1429] = new Tile();
			this.tile[1429].image = new Image(getClass().getResourceAsStream("/assets/Pmap/429.png"));

			this.tile[1430] = new Tile();
			this.tile[1430].image = new Image(getClass().getResourceAsStream("/assets/Pmap/430.png"));

			this.tile[1431] = new Tile();
			this.tile[1431].image = new Image(getClass().getResourceAsStream("/assets/Pmap/431.png"));

			this.tile[1432] = new Tile();
			this.tile[1432].image = new Image(getClass().getResourceAsStream("/assets/Pmap/432.png"));

			this.tile[1433] = new Tile();
			this.tile[1433].image = new Image(getClass().getResourceAsStream("/assets/Pmap/433.png"));

			this.tile[1434] = new Tile();
			this.tile[1434].image = new Image(getClass().getResourceAsStream("/assets/Pmap/434.png"));

			this.tile[1435] = new Tile();
			this.tile[1435].image = new Image(getClass().getResourceAsStream("/assets/Pmap/435.png"));

			this.tile[1436] = new Tile();
			this.tile[1436].image = new Image(getClass().getResourceAsStream("/assets/Pmap/436.png"));

			this.tile[1437] = new Tile();
			this.tile[1437].image = new Image(getClass().getResourceAsStream("/assets/Pmap/437.png"));

			this.tile[1438] = new Tile();
			this.tile[1438].image = new Image(getClass().getResourceAsStream("/assets/Pmap/438.png"));

			this.tile[1439] = new Tile();
			this.tile[1439].image = new Image(getClass().getResourceAsStream("/assets/Pmap/439.png"));

			this.tile[1440] = new Tile();
			this.tile[1440].image = new Image(getClass().getResourceAsStream("/assets/Pmap/440.png"));

			this.tile[1441] = new Tile();
			this.tile[1441].image = new Image(getClass().getResourceAsStream("/assets/Pmap/441.png"));

			this.tile[1442] = new Tile();
			this.tile[1442].image = new Image(getClass().getResourceAsStream("/assets/Pmap/442.png"));

			this.tile[1443] = new Tile();
			this.tile[1443].image = new Image(getClass().getResourceAsStream("/assets/Pmap/443.png"));
			this.tile[1443].collision = true;
			
			this.tile[1444] = new Tile();
			this.tile[1444].image = new Image(getClass().getResourceAsStream("/assets/Pmap/444.png"));

			this.tile[1445] = new Tile();
			this.tile[1445].image = new Image(getClass().getResourceAsStream("/assets/Pmap/445.png"));

			this.tile[1446] = new Tile();
			this.tile[1446].image = new Image(getClass().getResourceAsStream("/assets/Pmap/446.png"));

			this.tile[1447] = new Tile();
			this.tile[1447].image = new Image(getClass().getResourceAsStream("/assets/Pmap/447.png"));

			this.tile[1448] = new Tile();
			this.tile[1448].image = new Image(getClass().getResourceAsStream("/assets/Pmap/448.png"));

			this.tile[1449] = new Tile();
			this.tile[1449].image = new Image(getClass().getResourceAsStream("/assets/Pmap/449.png"));

			this.tile[1450] = new Tile();
			this.tile[1450].image = new Image(getClass().getResourceAsStream("/assets/Pmap/450.png"));
			this.tile[1450].collision = true;

			this.tile[1451] = new Tile();
			this.tile[1451].image = new Image(getClass().getResourceAsStream("/assets/Pmap/451.png"));
			this.tile[1451].collision = true;

			this.tile[1452] = new Tile();
			this.tile[1452].image = new Image(getClass().getResourceAsStream("/assets/Pmap/452.png"));

			this.tile[1453] = new Tile();
			this.tile[1453].image = new Image(getClass().getResourceAsStream("/assets/Pmap/453.png"));

			this.tile[1454] = new Tile();
			this.tile[1454].image = new Image(getClass().getResourceAsStream("/assets/Pmap/454.png"));

			this.tile[1455] = new Tile();
			this.tile[1455].image = new Image(getClass().getResourceAsStream("/assets/Pmap/455.png"));

			this.tile[1456] = new Tile();
			this.tile[1456].image = new Image(getClass().getResourceAsStream("/assets/Pmap/456.png"));

			this.tile[1457] = new Tile();
			this.tile[1457].image = new Image(getClass().getResourceAsStream("/assets/Pmap/457.png"));

			this.tile[1458] = new Tile();
			this.tile[1458].image = new Image(getClass().getResourceAsStream("/assets/Pmap/458.png"));
			this.tile[1458].collision = true;

			this.tile[1459] = new Tile();
			this.tile[1459].image = new Image(getClass().getResourceAsStream("/assets/Pmap/459.png"));

			this.tile[1460] = new Tile();
			this.tile[1460].image = new Image(getClass().getResourceAsStream("/assets/Pmap/460.png"));

			this.tile[1461] = new Tile();
			this.tile[1461].image = new Image(getClass().getResourceAsStream("/assets/Pmap/461.png"));

			this.tile[1462] = new Tile();
			this.tile[1462].image = new Image(getClass().getResourceAsStream("/assets/Pmap/462.png"));

			this.tile[1463] = new Tile();
			this.tile[1463].image = new Image(getClass().getResourceAsStream("/assets/Pmap/463.png"));

			this.tile[1464] = new Tile();
			this.tile[1464].image = new Image(getClass().getResourceAsStream("/assets/Pmap/464.png"));

			this.tile[1465] = new Tile();
			this.tile[1465].image = new Image(getClass().getResourceAsStream("/assets/Pmap/465.png"));

			this.tile[1466] = new Tile();
			this.tile[1466].image = new Image(getClass().getResourceAsStream("/assets/Pmap/466.png"));

			this.tile[1467] = new Tile();
			this.tile[1467].image = new Image(getClass().getResourceAsStream("/assets/Pmap/467.png"));

			this.tile[1468] = new Tile();
			this.tile[1468].image = new Image(getClass().getResourceAsStream("/assets/Pmap/468.png"));

			this.tile[1469] = new Tile();
			this.tile[1469].image = new Image(getClass().getResourceAsStream("/assets/Pmap/469.png"));

			this.tile[1470] = new Tile();
			this.tile[1470].image = new Image(getClass().getResourceAsStream("/assets/Pmap/470.png"));

			this.tile[1471] = new Tile();
			this.tile[1471].image = new Image(getClass().getResourceAsStream("/assets/Pmap/471.png"));

			this.tile[1472] = new Tile();
			this.tile[1472].image = new Image(getClass().getResourceAsStream("/assets/Pmap/472.png"));

			this.tile[1473] = new Tile();
			this.tile[1473].image = new Image(getClass().getResourceAsStream("/assets/Pmap/473.png"));

			this.tile[1474] = new Tile();
			this.tile[1474].image = new Image(getClass().getResourceAsStream("/assets/Pmap/474.png"));

			this.tile[1475] = new Tile();
			this.tile[1475].image = new Image(getClass().getResourceAsStream("/assets/Pmap/475.png"));

			this.tile[1476] = new Tile();
			this.tile[1476].image = new Image(getClass().getResourceAsStream("/assets/Pmap/476.png"));

			this.tile[1477] = new Tile();
			this.tile[1477].image = new Image(getClass().getResourceAsStream("/assets/Pmap/477.png"));

			this.tile[1478] = new Tile();
			this.tile[1478].image = new Image(getClass().getResourceAsStream("/assets/Pmap/478.png"));

			this.tile[1479] = new Tile();
			this.tile[1479].image = new Image(getClass().getResourceAsStream("/assets/Pmap/479.png"));

			this.tile[1480] = new Tile();
			this.tile[1480].image = new Image(getClass().getResourceAsStream("/assets/Pmap/480.png"));

			this.tile[1481] = new Tile();
			this.tile[1481].image = new Image(getClass().getResourceAsStream("/assets/Pmap/481.png"));

			this.tile[1482] = new Tile();
			this.tile[1482].image = new Image(getClass().getResourceAsStream("/assets/Pmap/482.png"));

			this.tile[1483] = new Tile();
			this.tile[1483].image = new Image(getClass().getResourceAsStream("/assets/Pmap/483.png"));

			this.tile[1484] = new Tile();
			this.tile[1484].image = new Image(getClass().getResourceAsStream("/assets/Pmap/484.png"));

			this.tile[1485] = new Tile();
			this.tile[1485].image = new Image(getClass().getResourceAsStream("/assets/Pmap/485.png"));

			this.tile[1486] = new Tile();
			this.tile[1486].image = new Image(getClass().getResourceAsStream("/assets/Pmap/486.png"));

			this.tile[1487] = new Tile();
			this.tile[1487].image = new Image(getClass().getResourceAsStream("/assets/Pmap/487.png"));

			this.tile[1488] = new Tile();
			this.tile[1488].image = new Image(getClass().getResourceAsStream("/assets/Pmap/488.png"));

			this.tile[1489] = new Tile();
			this.tile[1489].image = new Image(getClass().getResourceAsStream("/assets/Pmap/489.png"));

			this.tile[1490] = new Tile();
			this.tile[1490].image = new Image(getClass().getResourceAsStream("/assets/Pmap/490.png"));

			this.tile[1491] = new Tile();
			this.tile[1491].image = new Image(getClass().getResourceAsStream("/assets/Pmap/491.png"));

			this.tile[1492] = new Tile();
			this.tile[1492].image = new Image(getClass().getResourceAsStream("/assets/Pmap/492.png"));

			this.tile[1493] = new Tile();
			this.tile[1493].image = new Image(getClass().getResourceAsStream("/assets/Pmap/493.png"));
			this.tile[1493].collision = true;
			
			this.tile[1494] = new Tile();
			this.tile[1494].image = new Image(getClass().getResourceAsStream("/assets/Pmap/494.png"));

			this.tile[1495] = new Tile();
			this.tile[1495].image = new Image(getClass().getResourceAsStream("/assets/Pmap/495.png"));

			this.tile[1496] = new Tile();
			this.tile[1496].image = new Image(getClass().getResourceAsStream("/assets/Pmap/496.png"));

			this.tile[1497] = new Tile();
			this.tile[1497].image = new Image(getClass().getResourceAsStream("/assets/Pmap/497.png"));

			this.tile[1498] = new Tile();
			this.tile[1498].image = new Image(getClass().getResourceAsStream("/assets/Pmap/498.png"));

			this.tile[1499] = new Tile();
			this.tile[1499].image = new Image(getClass().getResourceAsStream("/assets/Pmap/499.png"));

			this.tile[1500] = new Tile();
			this.tile[1500].image = new Image(getClass().getResourceAsStream("/assets/Pmap/500.png"));
			this.tile[1500].collision = true;

			this.tile[1501] = new Tile();
			this.tile[1501].image = new Image(getClass().getResourceAsStream("/assets/Pmap/501.png"));
			this.tile[1501].collision = true;

			this.tile[1502] = new Tile();
			this.tile[1502].image = new Image(getClass().getResourceAsStream("/assets/Pmap/502.png"));

			this.tile[1503] = new Tile();
			this.tile[1503].image = new Image(getClass().getResourceAsStream("/assets/Pmap/503.png"));

			this.tile[1504] = new Tile();
			this.tile[1504].image = new Image(getClass().getResourceAsStream("/assets/Pmap/504.png"));

			this.tile[1505] = new Tile();
			this.tile[1505].image = new Image(getClass().getResourceAsStream("/assets/Pmap/505.png"));

			this.tile[1506] = new Tile();
			this.tile[1506].image = new Image(getClass().getResourceAsStream("/assets/Pmap/506.png"));

			this.tile[1507] = new Tile();
			this.tile[1507].image = new Image(getClass().getResourceAsStream("/assets/Pmap/507.png"));

			this.tile[1508] = new Tile();
			this.tile[1508].image = new Image(getClass().getResourceAsStream("/assets/Pmap/508.png"));
			this.tile[1508].collision = true;

			this.tile[1509] = new Tile();
			this.tile[1509].image = new Image(getClass().getResourceAsStream("/assets/Pmap/509.png"));

			this.tile[1510] = new Tile();
			this.tile[1510].image = new Image(getClass().getResourceAsStream("/assets/Pmap/510.png"));

			this.tile[1511] = new Tile();
			this.tile[1511].image = new Image(getClass().getResourceAsStream("/assets/Pmap/511.png"));

			this.tile[1512] = new Tile();
			this.tile[1512].image = new Image(getClass().getResourceAsStream("/assets/Pmap/512.png"));

			this.tile[1513] = new Tile();
			this.tile[1513].image = new Image(getClass().getResourceAsStream("/assets/Pmap/513.png"));

			this.tile[1514] = new Tile();
			this.tile[1514].image = new Image(getClass().getResourceAsStream("/assets/Pmap/514.png"));

			this.tile[1515] = new Tile();
			this.tile[1515].image = new Image(getClass().getResourceAsStream("/assets/Pmap/515.png"));

			this.tile[1516] = new Tile();
			this.tile[1516].image = new Image(getClass().getResourceAsStream("/assets/Pmap/516.png"));

			this.tile[1517] = new Tile();
			this.tile[1517].image = new Image(getClass().getResourceAsStream("/assets/Pmap/517.png"));

			this.tile[1518] = new Tile();
			this.tile[1518].image = new Image(getClass().getResourceAsStream("/assets/Pmap/518.png"));

			this.tile[1519] = new Tile();
			this.tile[1519].image = new Image(getClass().getResourceAsStream("/assets/Pmap/519.png"));

			this.tile[1520] = new Tile();
			this.tile[1520].image = new Image(getClass().getResourceAsStream("/assets/Pmap/520.png"));

			this.tile[1521] = new Tile();
			this.tile[1521].image = new Image(getClass().getResourceAsStream("/assets/Pmap/521.png"));

			this.tile[1522] = new Tile();
			this.tile[1522].image = new Image(getClass().getResourceAsStream("/assets/Pmap/522.png"));

			this.tile[1523] = new Tile();
			this.tile[1523].image = new Image(getClass().getResourceAsStream("/assets/Pmap/523.png"));

			this.tile[1524] = new Tile();
			this.tile[1524].image = new Image(getClass().getResourceAsStream("/assets/Pmap/524.png"));

			this.tile[1525] = new Tile();
			this.tile[1525].image = new Image(getClass().getResourceAsStream("/assets/Pmap/525.png"));

			this.tile[1526] = new Tile();
			this.tile[1526].image = new Image(getClass().getResourceAsStream("/assets/Pmap/526.png"));

			this.tile[1527] = new Tile();
			this.tile[1527].image = new Image(getClass().getResourceAsStream("/assets/Pmap/527.png"));

			this.tile[1528] = new Tile();
			this.tile[1528].image = new Image(getClass().getResourceAsStream("/assets/Pmap/528.png"));

			this.tile[1529] = new Tile();
			this.tile[1529].image = new Image(getClass().getResourceAsStream("/assets/Pmap/529.png"));

			this.tile[1530] = new Tile();
			this.tile[1530].image = new Image(getClass().getResourceAsStream("/assets/Pmap/530.png"));

			this.tile[1531] = new Tile();
			this.tile[1531].image = new Image(getClass().getResourceAsStream("/assets/Pmap/531.png"));

			this.tile[1532] = new Tile();
			this.tile[1532].image = new Image(getClass().getResourceAsStream("/assets/Pmap/532.png"));

			this.tile[1533] = new Tile();
			this.tile[1533].image = new Image(getClass().getResourceAsStream("/assets/Pmap/533.png"));

			this.tile[1534] = new Tile();
			this.tile[1534].image = new Image(getClass().getResourceAsStream("/assets/Pmap/534.png"));

			this.tile[1535] = new Tile();
			this.tile[1535].image = new Image(getClass().getResourceAsStream("/assets/Pmap/535.png"));

			this.tile[1536] = new Tile();
			this.tile[1536].image = new Image(getClass().getResourceAsStream("/assets/Pmap/536.png"));

			this.tile[1537] = new Tile();
			this.tile[1537].image = new Image(getClass().getResourceAsStream("/assets/Pmap/537.png"));

			this.tile[1538] = new Tile();
			this.tile[1538].image = new Image(getClass().getResourceAsStream("/assets/Pmap/538.png"));

			this.tile[1539] = new Tile();
			this.tile[1539].image = new Image(getClass().getResourceAsStream("/assets/Pmap/539.png"));

			this.tile[1540] = new Tile();
			this.tile[1540].image = new Image(getClass().getResourceAsStream("/assets/Pmap/540.png"));

			this.tile[1541] = new Tile();
			this.tile[1541].image = new Image(getClass().getResourceAsStream("/assets/Pmap/541.png"));

			this.tile[1542] = new Tile();
			this.tile[1542].image = new Image(getClass().getResourceAsStream("/assets/Pmap/542.png"));

			this.tile[1543] = new Tile();
			this.tile[1543].image = new Image(getClass().getResourceAsStream("/assets/Pmap/543.png"));
			this.tile[1543].collision = true;
			
			this.tile[1544] = new Tile();
			this.tile[1544].image = new Image(getClass().getResourceAsStream("/assets/Pmap/544.png"));

			this.tile[1545] = new Tile();
			this.tile[1545].image = new Image(getClass().getResourceAsStream("/assets/Pmap/545.png"));

			this.tile[1546] = new Tile();
			this.tile[1546].image = new Image(getClass().getResourceAsStream("/assets/Pmap/546.png"));

			this.tile[1547] = new Tile();
			this.tile[1547].image = new Image(getClass().getResourceAsStream("/assets/Pmap/547.png"));

			this.tile[1548] = new Tile();
			this.tile[1548].image = new Image(getClass().getResourceAsStream("/assets/Pmap/548.png"));

			this.tile[1549] = new Tile();
			this.tile[1549].image = new Image(getClass().getResourceAsStream("/assets/Pmap/549.png"));

			this.tile[1550] = new Tile();
			this.tile[1550].image = new Image(getClass().getResourceAsStream("/assets/Pmap/550.png"));
			this.tile[1550].collision = true;

			this.tile[1551] = new Tile();
			this.tile[1551].image = new Image(getClass().getResourceAsStream("/assets/Pmap/551.png"));
			this.tile[1551].collision = true;

			this.tile[1552] = new Tile();
			this.tile[1552].image = new Image(getClass().getResourceAsStream("/assets/Pmap/552.png"));

			this.tile[1553] = new Tile();
			this.tile[1553].image = new Image(getClass().getResourceAsStream("/assets/Pmap/553.png"));

			this.tile[1554] = new Tile();
			this.tile[1554].image = new Image(getClass().getResourceAsStream("/assets/Pmap/554.png"));

			this.tile[1555] = new Tile();
			this.tile[1555].image = new Image(getClass().getResourceAsStream("/assets/Pmap/555.png"));

			this.tile[1556] = new Tile();
			this.tile[1556].image = new Image(getClass().getResourceAsStream("/assets/Pmap/556.png"));

			this.tile[1557] = new Tile();
			this.tile[1557].image = new Image(getClass().getResourceAsStream("/assets/Pmap/557.png"));

			this.tile[1558] = new Tile();
			this.tile[1558].image = new Image(getClass().getResourceAsStream("/assets/Pmap/558.png"));
			this.tile[1558].collision = true;

			this.tile[1559] = new Tile();
			this.tile[1559].image = new Image(getClass().getResourceAsStream("/assets/Pmap/559.png"));

			this.tile[1560] = new Tile();
			this.tile[1560].image = new Image(getClass().getResourceAsStream("/assets/Pmap/560.png"));

			this.tile[1561] = new Tile();
			this.tile[1561].image = new Image(getClass().getResourceAsStream("/assets/Pmap/561.png"));

			this.tile[1562] = new Tile();
			this.tile[1562].image = new Image(getClass().getResourceAsStream("/assets/Pmap/562.png"));

			this.tile[1563] = new Tile();
			this.tile[1563].image = new Image(getClass().getResourceAsStream("/assets/Pmap/563.png"));

			this.tile[1564] = new Tile();
			this.tile[1564].image = new Image(getClass().getResourceAsStream("/assets/Pmap/564.png"));

			this.tile[1565] = new Tile();
			this.tile[1565].image = new Image(getClass().getResourceAsStream("/assets/Pmap/565.png"));

			this.tile[1566] = new Tile();
			this.tile[1566].image = new Image(getClass().getResourceAsStream("/assets/Pmap/566.png"));

			this.tile[1567] = new Tile();
			this.tile[1567].image = new Image(getClass().getResourceAsStream("/assets/Pmap/567.png"));

			this.tile[1568] = new Tile();
			this.tile[1568].image = new Image(getClass().getResourceAsStream("/assets/Pmap/568.png"));

			this.tile[1569] = new Tile();
			this.tile[1569].image = new Image(getClass().getResourceAsStream("/assets/Pmap/569.png"));

			this.tile[1570] = new Tile();
			this.tile[1570].image = new Image(getClass().getResourceAsStream("/assets/Pmap/570.png"));

			this.tile[1571] = new Tile();
			this.tile[1571].image = new Image(getClass().getResourceAsStream("/assets/Pmap/571.png"));

			this.tile[1572] = new Tile();
			this.tile[1572].image = new Image(getClass().getResourceAsStream("/assets/Pmap/572.png"));

			this.tile[1573] = new Tile();
			this.tile[1573].image = new Image(getClass().getResourceAsStream("/assets/Pmap/573.png"));

			this.tile[1574] = new Tile();
			this.tile[1574].image = new Image(getClass().getResourceAsStream("/assets/Pmap/574.png"));

			this.tile[1575] = new Tile();
			this.tile[1575].image = new Image(getClass().getResourceAsStream("/assets/Pmap/575.png"));

			this.tile[1576] = new Tile();
			this.tile[1576].image = new Image(getClass().getResourceAsStream("/assets/Pmap/576.png"));

			this.tile[1577] = new Tile();
			this.tile[1577].image = new Image(getClass().getResourceAsStream("/assets/Pmap/577.png"));

			this.tile[1578] = new Tile();
			this.tile[1578].image = new Image(getClass().getResourceAsStream("/assets/Pmap/578.png"));

			this.tile[1579] = new Tile();
			this.tile[1579].image = new Image(getClass().getResourceAsStream("/assets/Pmap/579.png"));

			this.tile[1580] = new Tile();
			this.tile[1580].image = new Image(getClass().getResourceAsStream("/assets/Pmap/580.png"));

			this.tile[1581] = new Tile();
			this.tile[1581].image = new Image(getClass().getResourceAsStream("/assets/Pmap/581.png"));

			this.tile[1582] = new Tile();
			this.tile[1582].image = new Image(getClass().getResourceAsStream("/assets/Pmap/582.png"));

			this.tile[1583] = new Tile();
			this.tile[1583].image = new Image(getClass().getResourceAsStream("/assets/Pmap/583.png"));

			this.tile[1584] = new Tile();
			this.tile[1584].image = new Image(getClass().getResourceAsStream("/assets/Pmap/584.png"));

			this.tile[1585] = new Tile();
			this.tile[1585].image = new Image(getClass().getResourceAsStream("/assets/Pmap/585.png"));

			this.tile[1586] = new Tile();
			this.tile[1586].image = new Image(getClass().getResourceAsStream("/assets/Pmap/586.png"));

			this.tile[1587] = new Tile();
			this.tile[1587].image = new Image(getClass().getResourceAsStream("/assets/Pmap/587.png"));

			this.tile[1588] = new Tile();
			this.tile[1588].image = new Image(getClass().getResourceAsStream("/assets/Pmap/588.png"));

			this.tile[1589] = new Tile();
			this.tile[1589].image = new Image(getClass().getResourceAsStream("/assets/Pmap/589.png"));

			this.tile[1590] = new Tile();
			this.tile[1590].image = new Image(getClass().getResourceAsStream("/assets/Pmap/590.png"));

			this.tile[1591] = new Tile();
			this.tile[1591].image = new Image(getClass().getResourceAsStream("/assets/Pmap/591.png"));

			this.tile[1592] = new Tile();
			this.tile[1592].image = new Image(getClass().getResourceAsStream("/assets/Pmap/592.png"));

			this.tile[1593] = new Tile();
			this.tile[1593].image = new Image(getClass().getResourceAsStream("/assets/Pmap/593.png"));
			this.tile[1593].collision = true;
			
			this.tile[1594] = new Tile();
			this.tile[1594].image = new Image(getClass().getResourceAsStream("/assets/Pmap/594.png"));

			this.tile[1595] = new Tile();
			this.tile[1595].image = new Image(getClass().getResourceAsStream("/assets/Pmap/595.png"));

			this.tile[1596] = new Tile();
			this.tile[1596].image = new Image(getClass().getResourceAsStream("/assets/Pmap/596.png"));

			this.tile[1597] = new Tile();
			this.tile[1597].image = new Image(getClass().getResourceAsStream("/assets/Pmap/597.png"));

			this.tile[1598] = new Tile();
			this.tile[1598].image = new Image(getClass().getResourceAsStream("/assets/Pmap/598.png"));

			this.tile[1599] = new Tile();
			this.tile[1599].image = new Image(getClass().getResourceAsStream("/assets/Pmap/599.png"));

			this.tile[1600] = new Tile();
			this.tile[1600].image = new Image(getClass().getResourceAsStream("/assets/Pmap/600.png"));
			this.tile[1600].collision = true;

			this.tile[1601] = new Tile();
			this.tile[1601].image = new Image(getClass().getResourceAsStream("/assets/Pmap/601.png"));
			this.tile[1601].collision = true;

			this.tile[1602] = new Tile();
			this.tile[1602].image = new Image(getClass().getResourceAsStream("/assets/Pmap/602.png"));

			this.tile[1603] = new Tile();
			this.tile[1603].image = new Image(getClass().getResourceAsStream("/assets/Pmap/603.png"));

			this.tile[1604] = new Tile();
			this.tile[1604].image = new Image(getClass().getResourceAsStream("/assets/Pmap/604.png"));

			this.tile[1605] = new Tile();
			this.tile[1605].image = new Image(getClass().getResourceAsStream("/assets/Pmap/605.png"));

			this.tile[1606] = new Tile();
			this.tile[1606].image = new Image(getClass().getResourceAsStream("/assets/Pmap/606.png"));

			this.tile[1607] = new Tile();
			this.tile[1607].image = new Image(getClass().getResourceAsStream("/assets/Pmap/607.png"));

			this.tile[1608] = new Tile();
			this.tile[1608].image = new Image(getClass().getResourceAsStream("/assets/Pmap/608.png"));
			this.tile[1608].collision = true;

			this.tile[1609] = new Tile();
			this.tile[1609].image = new Image(getClass().getResourceAsStream("/assets/Pmap/609.png"));

			this.tile[1610] = new Tile();
			this.tile[1610].image = new Image(getClass().getResourceAsStream("/assets/Pmap/610.png"));

			this.tile[1611] = new Tile();
			this.tile[1611].image = new Image(getClass().getResourceAsStream("/assets/Pmap/611.png"));

			this.tile[1612] = new Tile();
			this.tile[1612].image = new Image(getClass().getResourceAsStream("/assets/Pmap/612.png"));

			this.tile[1613] = new Tile();
			this.tile[1613].image = new Image(getClass().getResourceAsStream("/assets/Pmap/613.png"));

			this.tile[1614] = new Tile();
			this.tile[1614].image = new Image(getClass().getResourceAsStream("/assets/Pmap/614.png"));

			this.tile[1615] = new Tile();
			this.tile[1615].image = new Image(getClass().getResourceAsStream("/assets/Pmap/615.png"));

			this.tile[1616] = new Tile();
			this.tile[1616].image = new Image(getClass().getResourceAsStream("/assets/Pmap/616.png"));

			this.tile[1617] = new Tile();
			this.tile[1617].image = new Image(getClass().getResourceAsStream("/assets/Pmap/617.png"));

			this.tile[1618] = new Tile();
			this.tile[1618].image = new Image(getClass().getResourceAsStream("/assets/Pmap/618.png"));

			this.tile[1619] = new Tile();
			this.tile[1619].image = new Image(getClass().getResourceAsStream("/assets/Pmap/619.png"));

			this.tile[1620] = new Tile();
			this.tile[1620].image = new Image(getClass().getResourceAsStream("/assets/Pmap/620.png"));

			this.tile[1621] = new Tile();
			this.tile[1621].image = new Image(getClass().getResourceAsStream("/assets/Pmap/621.png"));

			this.tile[1622] = new Tile();
			this.tile[1622].image = new Image(getClass().getResourceAsStream("/assets/Pmap/622.png"));

			this.tile[1623] = new Tile();
			this.tile[1623].image = new Image(getClass().getResourceAsStream("/assets/Pmap/623.png"));

			this.tile[1624] = new Tile();
			this.tile[1624].image = new Image(getClass().getResourceAsStream("/assets/Pmap/624.png"));

			this.tile[1625] = new Tile();
			this.tile[1625].image = new Image(getClass().getResourceAsStream("/assets/Pmap/625.png"));

			this.tile[1626] = new Tile();
			this.tile[1626].image = new Image(getClass().getResourceAsStream("/assets/Pmap/626.png"));

			this.tile[1627] = new Tile();
			this.tile[1627].image = new Image(getClass().getResourceAsStream("/assets/Pmap/627.png"));

			this.tile[1628] = new Tile();
			this.tile[1628].image = new Image(getClass().getResourceAsStream("/assets/Pmap/628.png"));

			this.tile[1629] = new Tile();
			this.tile[1629].image = new Image(getClass().getResourceAsStream("/assets/Pmap/629.png"));

			this.tile[1630] = new Tile();
			this.tile[1630].image = new Image(getClass().getResourceAsStream("/assets/Pmap/630.png"));

			this.tile[1631] = new Tile();
			this.tile[1631].image = new Image(getClass().getResourceAsStream("/assets/Pmap/631.png"));

			this.tile[1632] = new Tile();
			this.tile[1632].image = new Image(getClass().getResourceAsStream("/assets/Pmap/632.png"));

			this.tile[1633] = new Tile();
			this.tile[1633].image = new Image(getClass().getResourceAsStream("/assets/Pmap/633.png"));

			this.tile[1634] = new Tile();
			this.tile[1634].image = new Image(getClass().getResourceAsStream("/assets/Pmap/634.png"));

			this.tile[1635] = new Tile();
			this.tile[1635].image = new Image(getClass().getResourceAsStream("/assets/Pmap/635.png"));

			this.tile[1636] = new Tile();
			this.tile[1636].image = new Image(getClass().getResourceAsStream("/assets/Pmap/636.png"));

			this.tile[1637] = new Tile();
			this.tile[1637].image = new Image(getClass().getResourceAsStream("/assets/Pmap/637.png"));

			this.tile[1638] = new Tile();
			this.tile[1638].image = new Image(getClass().getResourceAsStream("/assets/Pmap/638.png"));

			this.tile[1639] = new Tile();
			this.tile[1639].image = new Image(getClass().getResourceAsStream("/assets/Pmap/639.png"));

			this.tile[1640] = new Tile();
			this.tile[1640].image = new Image(getClass().getResourceAsStream("/assets/Pmap/640.png"));

			this.tile[1641] = new Tile();
			this.tile[1641].image = new Image(getClass().getResourceAsStream("/assets/Pmap/641.png"));

			this.tile[1642] = new Tile();
			this.tile[1642].image = new Image(getClass().getResourceAsStream("/assets/Pmap/642.png"));

			this.tile[1643] = new Tile();
			this.tile[1643].image = new Image(getClass().getResourceAsStream("/assets/Pmap/643.png"));
			this.tile[1643].collision = true;
			
			this.tile[1644] = new Tile();
			this.tile[1644].image = new Image(getClass().getResourceAsStream("/assets/Pmap/644.png"));

			this.tile[1645] = new Tile();
			this.tile[1645].image = new Image(getClass().getResourceAsStream("/assets/Pmap/645.png"));

			this.tile[1646] = new Tile();
			this.tile[1646].image = new Image(getClass().getResourceAsStream("/assets/Pmap/646.png"));

			this.tile[1647] = new Tile();
			this.tile[1647].image = new Image(getClass().getResourceAsStream("/assets/Pmap/647.png"));

			this.tile[1648] = new Tile();
			this.tile[1648].image = new Image(getClass().getResourceAsStream("/assets/Pmap/648.png"));

			this.tile[1649] = new Tile();
			this.tile[1649].image = new Image(getClass().getResourceAsStream("/assets/Pmap/649.png"));

			this.tile[1650] = new Tile();
			this.tile[1650].image = new Image(getClass().getResourceAsStream("/assets/Pmap/650.png"));
			this.tile[1650].collision = true;

			this.tile[1651] = new Tile();
			this.tile[1651].image = new Image(getClass().getResourceAsStream("/assets/Pmap/651.png"));
			this.tile[1651].collision = true;

			this.tile[1652] = new Tile();
			this.tile[1652].image = new Image(getClass().getResourceAsStream("/assets/Pmap/652.png"));

			this.tile[1653] = new Tile();
			this.tile[1653].image = new Image(getClass().getResourceAsStream("/assets/Pmap/653.png"));

			this.tile[1654] = new Tile();
			this.tile[1654].image = new Image(getClass().getResourceAsStream("/assets/Pmap/654.png"));

			this.tile[1655] = new Tile();
			this.tile[1655].image = new Image(getClass().getResourceAsStream("/assets/Pmap/655.png"));

			this.tile[1656] = new Tile();
			this.tile[1656].image = new Image(getClass().getResourceAsStream("/assets/Pmap/656.png"));

			this.tile[1657] = new Tile();
			this.tile[1657].image = new Image(getClass().getResourceAsStream("/assets/Pmap/657.png"));

			this.tile[1658] = new Tile();
			this.tile[1658].image = new Image(getClass().getResourceAsStream("/assets/Pmap/658.png"));
			this.tile[1658].collision = true;

			this.tile[1659] = new Tile();
			this.tile[1659].image = new Image(getClass().getResourceAsStream("/assets/Pmap/659.png"));

			this.tile[1660] = new Tile();
			this.tile[1660].image = new Image(getClass().getResourceAsStream("/assets/Pmap/660.png"));

			this.tile[1661] = new Tile();
			this.tile[1661].image = new Image(getClass().getResourceAsStream("/assets/Pmap/661.png"));

			this.tile[1662] = new Tile();
			this.tile[1662].image = new Image(getClass().getResourceAsStream("/assets/Pmap/662.png"));

			this.tile[1663] = new Tile();
			this.tile[1663].image = new Image(getClass().getResourceAsStream("/assets/Pmap/663.png"));

			this.tile[1664] = new Tile();
			this.tile[1664].image = new Image(getClass().getResourceAsStream("/assets/Pmap/664.png"));

			this.tile[1665] = new Tile();
			this.tile[1665].image = new Image(getClass().getResourceAsStream("/assets/Pmap/665.png"));

			this.tile[1666] = new Tile();
			this.tile[1666].image = new Image(getClass().getResourceAsStream("/assets/Pmap/666.png"));

			this.tile[1667] = new Tile();
			this.tile[1667].image = new Image(getClass().getResourceAsStream("/assets/Pmap/667.png"));

			this.tile[1668] = new Tile();
			this.tile[1668].image = new Image(getClass().getResourceAsStream("/assets/Pmap/668.png"));

			this.tile[1669] = new Tile();
			this.tile[1669].image = new Image(getClass().getResourceAsStream("/assets/Pmap/669.png"));

			this.tile[1670] = new Tile();
			this.tile[1670].image = new Image(getClass().getResourceAsStream("/assets/Pmap/670.png"));

			this.tile[1671] = new Tile();
			this.tile[1671].image = new Image(getClass().getResourceAsStream("/assets/Pmap/671.png"));

			this.tile[1672] = new Tile();
			this.tile[1672].image = new Image(getClass().getResourceAsStream("/assets/Pmap/672.png"));

			this.tile[1673] = new Tile();
			this.tile[1673].image = new Image(getClass().getResourceAsStream("/assets/Pmap/673.png"));

			this.tile[1674] = new Tile();
			this.tile[1674].image = new Image(getClass().getResourceAsStream("/assets/Pmap/674.png"));

			this.tile[1675] = new Tile();
			this.tile[1675].image = new Image(getClass().getResourceAsStream("/assets/Pmap/675.png"));

			this.tile[1676] = new Tile();
			this.tile[1676].image = new Image(getClass().getResourceAsStream("/assets/Pmap/676.png"));

			this.tile[1677] = new Tile();
			this.tile[1677].image = new Image(getClass().getResourceAsStream("/assets/Pmap/677.png"));

			this.tile[1678] = new Tile();
			this.tile[1678].image = new Image(getClass().getResourceAsStream("/assets/Pmap/678.png"));

			this.tile[1679] = new Tile();
			this.tile[1679].image = new Image(getClass().getResourceAsStream("/assets/Pmap/679.png"));

			this.tile[1680] = new Tile();
			this.tile[1680].image = new Image(getClass().getResourceAsStream("/assets/Pmap/680.png"));

			this.tile[1681] = new Tile();
			this.tile[1681].image = new Image(getClass().getResourceAsStream("/assets/Pmap/681.png"));

			this.tile[1682] = new Tile();
			this.tile[1682].image = new Image(getClass().getResourceAsStream("/assets/Pmap/682.png"));

			this.tile[1683] = new Tile();
			this.tile[1683].image = new Image(getClass().getResourceAsStream("/assets/Pmap/683.png"));

			this.tile[1684] = new Tile();
			this.tile[1684].image = new Image(getClass().getResourceAsStream("/assets/Pmap/684.png"));

			this.tile[1685] = new Tile();
			this.tile[1685].image = new Image(getClass().getResourceAsStream("/assets/Pmap/685.png"));

			this.tile[1686] = new Tile();
			this.tile[1686].image = new Image(getClass().getResourceAsStream("/assets/Pmap/686.png"));

			this.tile[1687] = new Tile();
			this.tile[1687].image = new Image(getClass().getResourceAsStream("/assets/Pmap/687.png"));

			this.tile[1688] = new Tile();
			this.tile[1688].image = new Image(getClass().getResourceAsStream("/assets/Pmap/688.png"));

			this.tile[1689] = new Tile();
			this.tile[1689].image = new Image(getClass().getResourceAsStream("/assets/Pmap/689.png"));

			this.tile[1690] = new Tile();
			this.tile[1690].image = new Image(getClass().getResourceAsStream("/assets/Pmap/690.png"));

			this.tile[1691] = new Tile();
			this.tile[1691].image = new Image(getClass().getResourceAsStream("/assets/Pmap/691.png"));

			this.tile[1692] = new Tile();
			this.tile[1692].image = new Image(getClass().getResourceAsStream("/assets/Pmap/692.png"));

			this.tile[1693] = new Tile();
			this.tile[1693].image = new Image(getClass().getResourceAsStream("/assets/Pmap/693.png"));
			this.tile[1693].collision = true;
			
			this.tile[1694] = new Tile();
			this.tile[1694].image = new Image(getClass().getResourceAsStream("/assets/Pmap/694.png"));

			this.tile[1695] = new Tile();
			this.tile[1695].image = new Image(getClass().getResourceAsStream("/assets/Pmap/695.png"));

			this.tile[1696] = new Tile();
			this.tile[1696].image = new Image(getClass().getResourceAsStream("/assets/Pmap/696.png"));

			this.tile[1697] = new Tile();
			this.tile[1697].image = new Image(getClass().getResourceAsStream("/assets/Pmap/697.png"));

			this.tile[1698] = new Tile();
			this.tile[1698].image = new Image(getClass().getResourceAsStream("/assets/Pmap/698.png"));

			this.tile[1699] = new Tile();
			this.tile[1699].image = new Image(getClass().getResourceAsStream("/assets/Pmap/699.png"));

			this.tile[1700] = new Tile();
			this.tile[1700].image = new Image(getClass().getResourceAsStream("/assets/Pmap/700.png"));
			this.tile[1700].collision = true;

			this.tile[1701] = new Tile();
			this.tile[1701].image = new Image(getClass().getResourceAsStream("/assets/Pmap/701.png"));
			this.tile[1701].collision = true;

			this.tile[1702] = new Tile();
			this.tile[1702].image = new Image(getClass().getResourceAsStream("/assets/Pmap/702.png"));

			this.tile[1703] = new Tile();
			this.tile[1703].image = new Image(getClass().getResourceAsStream("/assets/Pmap/703.png"));

			this.tile[1704] = new Tile();
			this.tile[1704].image = new Image(getClass().getResourceAsStream("/assets/Pmap/704.png"));

			this.tile[1705] = new Tile();
			this.tile[1705].image = new Image(getClass().getResourceAsStream("/assets/Pmap/705.png"));

			this.tile[1706] = new Tile();
			this.tile[1706].image = new Image(getClass().getResourceAsStream("/assets/Pmap/706.png"));

			this.tile[1707] = new Tile();
			this.tile[1707].image = new Image(getClass().getResourceAsStream("/assets/Pmap/707.png"));

			this.tile[1708] = new Tile();
			this.tile[1708].image = new Image(getClass().getResourceAsStream("/assets/Pmap/708.png"));
			this.tile[1708].collision = true;

			this.tile[1709] = new Tile();
			this.tile[1709].image = new Image(getClass().getResourceAsStream("/assets/Pmap/709.png"));

			this.tile[1710] = new Tile();
			this.tile[1710].image = new Image(getClass().getResourceAsStream("/assets/Pmap/710.png"));

			this.tile[1711] = new Tile();
			this.tile[1711].image = new Image(getClass().getResourceAsStream("/assets/Pmap/711.png"));

			this.tile[1712] = new Tile();
			this.tile[1712].image = new Image(getClass().getResourceAsStream("/assets/Pmap/712.png"));

			this.tile[1713] = new Tile();
			this.tile[1713].image = new Image(getClass().getResourceAsStream("/assets/Pmap/713.png"));

			this.tile[1714] = new Tile();
			this.tile[1714].image = new Image(getClass().getResourceAsStream("/assets/Pmap/714.png"));

			this.tile[1715] = new Tile();
			this.tile[1715].image = new Image(getClass().getResourceAsStream("/assets/Pmap/715.png"));

			this.tile[1716] = new Tile();
			this.tile[1716].image = new Image(getClass().getResourceAsStream("/assets/Pmap/716.png"));

			this.tile[1717] = new Tile();
			this.tile[1717].image = new Image(getClass().getResourceAsStream("/assets/Pmap/717.png"));

			this.tile[1718] = new Tile();
			this.tile[1718].image = new Image(getClass().getResourceAsStream("/assets/Pmap/718.png"));

			this.tile[1719] = new Tile();
			this.tile[1719].image = new Image(getClass().getResourceAsStream("/assets/Pmap/719.png"));

			this.tile[1720] = new Tile();
			this.tile[1720].image = new Image(getClass().getResourceAsStream("/assets/Pmap/720.png"));

			this.tile[1721] = new Tile();
			this.tile[1721].image = new Image(getClass().getResourceAsStream("/assets/Pmap/721.png"));

			this.tile[1722] = new Tile();
			this.tile[1722].image = new Image(getClass().getResourceAsStream("/assets/Pmap/722.png"));

			this.tile[1723] = new Tile();
			this.tile[1723].image = new Image(getClass().getResourceAsStream("/assets/Pmap/723.png"));

			this.tile[1724] = new Tile();
			this.tile[1724].image = new Image(getClass().getResourceAsStream("/assets/Pmap/724.png"));

			this.tile[1725] = new Tile();
			this.tile[1725].image = new Image(getClass().getResourceAsStream("/assets/Pmap/725.png"));

			this.tile[1726] = new Tile();
			this.tile[1726].image = new Image(getClass().getResourceAsStream("/assets/Pmap/726.png"));

			this.tile[1727] = new Tile();
			this.tile[1727].image = new Image(getClass().getResourceAsStream("/assets/Pmap/727.png"));

			this.tile[1728] = new Tile();
			this.tile[1728].image = new Image(getClass().getResourceAsStream("/assets/Pmap/728.png"));

			this.tile[1729] = new Tile();
			this.tile[1729].image = new Image(getClass().getResourceAsStream("/assets/Pmap/729.png"));

			this.tile[1730] = new Tile();
			this.tile[1730].image = new Image(getClass().getResourceAsStream("/assets/Pmap/730.png"));

			this.tile[1731] = new Tile();
			this.tile[1731].image = new Image(getClass().getResourceAsStream("/assets/Pmap/731.png"));

			this.tile[1732] = new Tile();
			this.tile[1732].image = new Image(getClass().getResourceAsStream("/assets/Pmap/732.png"));

			this.tile[1733] = new Tile();
			this.tile[1733].image = new Image(getClass().getResourceAsStream("/assets/Pmap/733.png"));

			this.tile[1734] = new Tile();
			this.tile[1734].image = new Image(getClass().getResourceAsStream("/assets/Pmap/734.png"));

			this.tile[1735] = new Tile();
			this.tile[1735].image = new Image(getClass().getResourceAsStream("/assets/Pmap/735.png"));

			this.tile[1736] = new Tile();
			this.tile[1736].image = new Image(getClass().getResourceAsStream("/assets/Pmap/736.png"));

			this.tile[1737] = new Tile();
			this.tile[1737].image = new Image(getClass().getResourceAsStream("/assets/Pmap/737.png"));

			this.tile[1738] = new Tile();
			this.tile[1738].image = new Image(getClass().getResourceAsStream("/assets/Pmap/738.png"));

			this.tile[1739] = new Tile();
			this.tile[1739].image = new Image(getClass().getResourceAsStream("/assets/Pmap/739.png"));

			this.tile[1740] = new Tile();
			this.tile[1740].image = new Image(getClass().getResourceAsStream("/assets/Pmap/740.png"));

			this.tile[1741] = new Tile();
			this.tile[1741].image = new Image(getClass().getResourceAsStream("/assets/Pmap/741.png"));

			this.tile[1742] = new Tile();
			this.tile[1742].image = new Image(getClass().getResourceAsStream("/assets/Pmap/742.png"));

			this.tile[1743] = new Tile();
			this.tile[1743].image = new Image(getClass().getResourceAsStream("/assets/Pmap/743.png"));
			this.tile[1743].collision = true;
			
			this.tile[1744] = new Tile();
			this.tile[1744].image = new Image(getClass().getResourceAsStream("/assets/Pmap/744.png"));

			this.tile[1745] = new Tile();
			this.tile[1745].image = new Image(getClass().getResourceAsStream("/assets/Pmap/745.png"));

			this.tile[1746] = new Tile();
			this.tile[1746].image = new Image(getClass().getResourceAsStream("/assets/Pmap/746.png"));

			this.tile[1747] = new Tile();
			this.tile[1747].image = new Image(getClass().getResourceAsStream("/assets/Pmap/747.png"));

			this.tile[1748] = new Tile();
			this.tile[1748].image = new Image(getClass().getResourceAsStream("/assets/Pmap/748.png"));

			this.tile[1749] = new Tile();
			this.tile[1749].image = new Image(getClass().getResourceAsStream("/assets/Pmap/749.png"));

			this.tile[1750] = new Tile();
			this.tile[1750].image = new Image(getClass().getResourceAsStream("/assets/Pmap/750.png"));
			this.tile[1750].collision = true;

			this.tile[1751] = new Tile();
			this.tile[1751].image = new Image(getClass().getResourceAsStream("/assets/Pmap/751.png"));
			this.tile[1751].collision = true;

			this.tile[1752] = new Tile();
			this.tile[1752].image = new Image(getClass().getResourceAsStream("/assets/Pmap/752.png"));
			this.tile[1752].collision = true;

			this.tile[1753] = new Tile();
			this.tile[1753].image = new Image(getClass().getResourceAsStream("/assets/Pmap/753.png"));
			this.tile[1753].collision = true;

			this.tile[1754] = new Tile();
			this.tile[1754].image = new Image(getClass().getResourceAsStream("/assets/Pmap/754.png"));
			this.tile[1754].collision = true;

			this.tile[1755] = new Tile();
			this.tile[1755].image = new Image(getClass().getResourceAsStream("/assets/Pmap/755.png"));
			this.tile[1755].collision = true;

			this.tile[1756] = new Tile();
			this.tile[1756].image = new Image(getClass().getResourceAsStream("/assets/Pmap/756.png"));
			this.tile[1756].collision = true;

			this.tile[1757] = new Tile();
			this.tile[1757].image = new Image(getClass().getResourceAsStream("/assets/Pmap/757.png"));
			this.tile[1757].collision = true;

			this.tile[1758] = new Tile();
			this.tile[1758].image = new Image(getClass().getResourceAsStream("/assets/Pmap/758.png"));
			this.tile[1758].collision = true;

			this.tile[1759] = new Tile();
			this.tile[1759].image = new Image(getClass().getResourceAsStream("/assets/Pmap/759.png"));
			this.tile[1759].collision = true;

			this.tile[1760] = new Tile();
			this.tile[1760].image = new Image(getClass().getResourceAsStream("/assets/Pmap/760.png"));
			this.tile[1760].collision = true;

			this.tile[1761] = new Tile();
			this.tile[1761].image = new Image(getClass().getResourceAsStream("/assets/Pmap/761.png"));
			this.tile[1761].collision = true;

			this.tile[1762] = new Tile();
			this.tile[1762].image = new Image(getClass().getResourceAsStream("/assets/Pmap/762.png"));
			this.tile[1762].collision = true;

			this.tile[1763] = new Tile();
			this.tile[1763].image = new Image(getClass().getResourceAsStream("/assets/Pmap/763.png"));
			this.tile[1763].collision = true;

			this.tile[1764] = new Tile();
			this.tile[1764].image = new Image(getClass().getResourceAsStream("/assets/Pmap/764.png"));
			this.tile[1764].collision = true;

			this.tile[1765] = new Tile();
			this.tile[1765].image = new Image(getClass().getResourceAsStream("/assets/Pmap/765.png"));
			this.tile[1765].collision = true;

			this.tile[1766] = new Tile();
			this.tile[1766].image = new Image(getClass().getResourceAsStream("/assets/Pmap/766.png"));
			this.tile[1766].collision = true;

			this.tile[1767] = new Tile();
			this.tile[1767].image = new Image(getClass().getResourceAsStream("/assets/Pmap/767.png"));
			this.tile[1767].collision = true;

			this.tile[1768] = new Tile();
			this.tile[1768].image = new Image(getClass().getResourceAsStream("/assets/Pmap/768.png"));
			this.tile[1768].collision = true;

			this.tile[1769] = new Tile();
			this.tile[1769].image = new Image(getClass().getResourceAsStream("/assets/Pmap/769.png"));
			this.tile[1769].collision = true;

			this.tile[1770] = new Tile();
			this.tile[1770].image = new Image(getClass().getResourceAsStream("/assets/Pmap/770.png"));
			this.tile[1770].collision = true;

			this.tile[1771] = new Tile();
			this.tile[1771].image = new Image(getClass().getResourceAsStream("/assets/Pmap/771.png"));
			this.tile[1771].collision = true;

			this.tile[1772] = new Tile();
			this.tile[1772].image = new Image(getClass().getResourceAsStream("/assets/Pmap/772.png"));

			this.tile[1773] = new Tile();
			this.tile[1773].image = new Image(getClass().getResourceAsStream("/assets/Pmap/773.png"));

			this.tile[1774] = new Tile();
			this.tile[1774].image = new Image(getClass().getResourceAsStream("/assets/Pmap/774.png"));

			this.tile[1775] = new Tile();
			this.tile[1775].image = new Image(getClass().getResourceAsStream("/assets/Pmap/775.png"));

			this.tile[1776] = new Tile();
			this.tile[1776].image = new Image(getClass().getResourceAsStream("/assets/Pmap/776.png"));

			this.tile[1777] = new Tile();
			this.tile[1777].image = new Image(getClass().getResourceAsStream("/assets/Pmap/777.png"));

			this.tile[1778] = new Tile();
			this.tile[1778].image = new Image(getClass().getResourceAsStream("/assets/Pmap/778.png"));

			this.tile[1779] = new Tile();
			this.tile[1779].image = new Image(getClass().getResourceAsStream("/assets/Pmap/779.png"));
			this.tile[1779].collision = true;

			this.tile[1780] = new Tile();
			this.tile[1780].image = new Image(getClass().getResourceAsStream("/assets/Pmap/780.png"));
			this.tile[1780].collision = true;

			this.tile[1781] = new Tile();
			this.tile[1781].image = new Image(getClass().getResourceAsStream("/assets/Pmap/781.png"));
			this.tile[1781].collision = true;

			this.tile[1782] = new Tile();
			this.tile[1782].image = new Image(getClass().getResourceAsStream("/assets/Pmap/782.png"));
			this.tile[1782].collision = true;

			this.tile[1783] = new Tile();
			this.tile[1783].image = new Image(getClass().getResourceAsStream("/assets/Pmap/783.png"));
			this.tile[1783].collision = true;

			this.tile[1784] = new Tile();
			this.tile[1784].image = new Image(getClass().getResourceAsStream("/assets/Pmap/784.png"));
			this.tile[1784].collision = true;

			this.tile[1785] = new Tile();
			this.tile[1785].image = new Image(getClass().getResourceAsStream("/assets/Pmap/785.png"));
			this.tile[1785].collision = true;

			this.tile[1786] = new Tile();
			this.tile[1786].image = new Image(getClass().getResourceAsStream("/assets/Pmap/786.png"));
			this.tile[1786].collision = true;

			this.tile[1787] = new Tile();
			this.tile[1787].image = new Image(getClass().getResourceAsStream("/assets/Pmap/787.png"));
			this.tile[1787].collision = true;

			this.tile[1788] = new Tile();
			this.tile[1788].image = new Image(getClass().getResourceAsStream("/assets/Pmap/788.png"));
			this.tile[1788].collision = true;

			this.tile[1789] = new Tile();
			this.tile[1789].image = new Image(getClass().getResourceAsStream("/assets/Pmap/789.png"));
			this.tile[1789].collision = true;

			this.tile[1790] = new Tile();
			this.tile[1790].image = new Image(getClass().getResourceAsStream("/assets/Pmap/790.png"));
			this.tile[1790].collision = true;

			this.tile[1791] = new Tile();
			this.tile[1791].image = new Image(getClass().getResourceAsStream("/assets/Pmap/791.png"));
			this.tile[1791].collision = true;

			this.tile[1792] = new Tile();
			this.tile[1792].image = new Image(getClass().getResourceAsStream("/assets/Pmap/792.png"));
			this.tile[1792].collision = true;

			this.tile[1793] = new Tile();
			this.tile[1793].image = new Image(getClass().getResourceAsStream("/assets/Pmap/793.png"));
			this.tile[1793].collision = true;

			this.tile[1794] = new Tile();
			this.tile[1794].image = new Image(getClass().getResourceAsStream("/assets/Pmap/794.png"));
			this.tile[1794].collision = true;

			this.tile[1795] = new Tile();
			this.tile[1795].image = new Image(getClass().getResourceAsStream("/assets/Pmap/795.png"));
			this.tile[1795].collision = true;

			this.tile[1796] = new Tile();
			this.tile[1796].image = new Image(getClass().getResourceAsStream("/assets/Pmap/796.png"));
			this.tile[1796].collision = true;

			this.tile[1797] = new Tile();
			this.tile[1797].image = new Image(getClass().getResourceAsStream("/assets/Pmap/797.png"));
			this.tile[1797].collision = true;

			this.tile[1798] = new Tile();
			this.tile[1798].image = new Image(getClass().getResourceAsStream("/assets/Pmap/798.png"));
			this.tile[1798].collision = true;

			this.tile[1799] = new Tile();
			this.tile[1799].image = new Image(getClass().getResourceAsStream("/assets/Pmap/799.png"));
			this.tile[1799].collision = true;

			this.tile[1800] = new Tile();
			this.tile[1800].image = new Image(getClass().getResourceAsStream("/assets/Pmap/800.png"));
			this.tile[1800].collision = true;

			this.tile[1801] = new Tile();
			this.tile[1801].image = new Image(getClass().getResourceAsStream("/assets/Pmap/801.png"));
			this.tile[1801].collision = true;

			this.tile[1802] = new Tile();
			this.tile[1802].image = new Image(getClass().getResourceAsStream("/assets/Pmap/802.png"));
			this.tile[1802].collision = true;

			this.tile[1803] = new Tile();
			this.tile[1803].image = new Image(getClass().getResourceAsStream("/assets/Pmap/803.png"));
			this.tile[1803].collision = true;

			this.tile[1804] = new Tile();
			this.tile[1804].image = new Image(getClass().getResourceAsStream("/assets/Pmap/804.png"));
			this.tile[1804].collision = true;

			this.tile[1805] = new Tile();
			this.tile[1805].image = new Image(getClass().getResourceAsStream("/assets/Pmap/805.png"));
			this.tile[1805].collision = true;

			this.tile[1806] = new Tile();
			this.tile[1806].image = new Image(getClass().getResourceAsStream("/assets/Pmap/806.png"));
			this.tile[1806].collision = true;

			this.tile[1807] = new Tile();
			this.tile[1807].image = new Image(getClass().getResourceAsStream("/assets/Pmap/807.png"));
			this.tile[1807].collision = true;

			this.tile[1808] = new Tile();
			this.tile[1808].image = new Image(getClass().getResourceAsStream("/assets/Pmap/808.png"));
			this.tile[1808].collision = true;

			this.tile[1809] = new Tile();
			this.tile[1809].image = new Image(getClass().getResourceAsStream("/assets/Pmap/809.png"));
			this.tile[1809].collision = true;

			this.tile[1810] = new Tile();
			this.tile[1810].image = new Image(getClass().getResourceAsStream("/assets/Pmap/810.png"));
			this.tile[1810].collision = true;

			this.tile[1811] = new Tile();
			this.tile[1811].image = new Image(getClass().getResourceAsStream("/assets/Pmap/811.png"));
			this.tile[1811].collision = true;

			this.tile[1812] = new Tile();
			this.tile[1812].image = new Image(getClass().getResourceAsStream("/assets/Pmap/812.png"));
			this.tile[1812].collision = true;

			this.tile[1813] = new Tile();
			this.tile[1813].image = new Image(getClass().getResourceAsStream("/assets/Pmap/813.png"));
			this.tile[1813].collision = true;

			this.tile[1814] = new Tile();
			this.tile[1814].image = new Image(getClass().getResourceAsStream("/assets/Pmap/814.png"));
			this.tile[1814].collision = true;

			this.tile[1815] = new Tile();
			this.tile[1815].image = new Image(getClass().getResourceAsStream("/assets/Pmap/815.png"));
			this.tile[1815].collision = true;

			this.tile[1816] = new Tile();
			this.tile[1816].image = new Image(getClass().getResourceAsStream("/assets/Pmap/816.png"));
			this.tile[1816].collision = true;

			this.tile[1817] = new Tile();
			this.tile[1817].image = new Image(getClass().getResourceAsStream("/assets/Pmap/817.png"));
			this.tile[1817].collision = true;

			this.tile[1818] = new Tile();
			this.tile[1818].image = new Image(getClass().getResourceAsStream("/assets/Pmap/818.png"));
			this.tile[1818].collision = true;

			this.tile[1819] = new Tile();
			this.tile[1819].image = new Image(getClass().getResourceAsStream("/assets/Pmap/819.png"));
			this.tile[1819].collision = true;

			this.tile[1820] = new Tile();
			this.tile[1820].image = new Image(getClass().getResourceAsStream("/assets/Pmap/820.png"));
			this.tile[1820].collision = true;

			this.tile[1821] = new Tile();
			this.tile[1821].image = new Image(getClass().getResourceAsStream("/assets/Pmap/821.png"));
			this.tile[1821].collision = true;

			this.tile[1822] = new Tile();
			this.tile[1822].image = new Image(getClass().getResourceAsStream("/assets/Pmap/822.png"));

			this.tile[1823] = new Tile();
			this.tile[1823].image = new Image(getClass().getResourceAsStream("/assets/Pmap/823.png"));

			this.tile[1824] = new Tile();
			this.tile[1824].image = new Image(getClass().getResourceAsStream("/assets/Pmap/824.png"));

			this.tile[1825] = new Tile();
			this.tile[1825].image = new Image(getClass().getResourceAsStream("/assets/Pmap/825.png"));

			this.tile[1826] = new Tile();
			this.tile[1826].image = new Image(getClass().getResourceAsStream("/assets/Pmap/826.png"));

			this.tile[1827] = new Tile();
			this.tile[1827].image = new Image(getClass().getResourceAsStream("/assets/Pmap/827.png"));

			this.tile[1828] = new Tile();
			this.tile[1828].image = new Image(getClass().getResourceAsStream("/assets/Pmap/828.png"));

			this.tile[1829] = new Tile();
			this.tile[1829].image = new Image(getClass().getResourceAsStream("/assets/Pmap/829.png"));
			this.tile[1829].collision = true;

			this.tile[1830] = new Tile();
			this.tile[1830].image = new Image(getClass().getResourceAsStream("/assets/Pmap/830.png"));
			this.tile[1830].collision = true;

			this.tile[1831] = new Tile();
			this.tile[1831].image = new Image(getClass().getResourceAsStream("/assets/Pmap/831.png"));
			this.tile[1831].collision = true;

			this.tile[1832] = new Tile();
			this.tile[1832].image = new Image(getClass().getResourceAsStream("/assets/Pmap/832.png"));
			this.tile[1832].collision = true;

			this.tile[1833] = new Tile();
			this.tile[1833].image = new Image(getClass().getResourceAsStream("/assets/Pmap/833.png"));
			this.tile[1833].collision = true;

			this.tile[1834] = new Tile();
			this.tile[1834].image = new Image(getClass().getResourceAsStream("/assets/Pmap/834.png"));
			this.tile[1834].collision = true;

			this.tile[1835] = new Tile();
			this.tile[1835].image = new Image(getClass().getResourceAsStream("/assets/Pmap/835.png"));
			this.tile[1835].collision = true;

			this.tile[1836] = new Tile();
			this.tile[1836].image = new Image(getClass().getResourceAsStream("/assets/Pmap/836.png"));
			this.tile[1836].collision = true;

			this.tile[1837] = new Tile();
			this.tile[1837].image = new Image(getClass().getResourceAsStream("/assets/Pmap/837.png"));
			this.tile[1837].collision = true;

			this.tile[1838] = new Tile();
			this.tile[1838].image = new Image(getClass().getResourceAsStream("/assets/Pmap/838.png"));
			this.tile[1838].collision = true;

			this.tile[1839] = new Tile();
			this.tile[1839].image = new Image(getClass().getResourceAsStream("/assets/Pmap/839.png"));
			this.tile[1839].collision = true;

			this.tile[1840] = new Tile();
			this.tile[1840].image = new Image(getClass().getResourceAsStream("/assets/Pmap/840.png"));
			this.tile[1840].collision = true;

			this.tile[1841] = new Tile();
			this.tile[1841].image = new Image(getClass().getResourceAsStream("/assets/Pmap/841.png"));
			this.tile[1841].collision = true;

			this.tile[1842] = new Tile();
			this.tile[1842].image = new Image(getClass().getResourceAsStream("/assets/Pmap/842.png"));
			this.tile[1842].collision = true;

			this.tile[1843] = new Tile();
			this.tile[1843].image = new Image(getClass().getResourceAsStream("/assets/Pmap/843.png"));
			this.tile[1843].collision = true;

			this.tile[1844] = new Tile();
			this.tile[1844].image = new Image(getClass().getResourceAsStream("/assets/Pmap/844.png"));
			this.tile[1844].collision = true;

			this.tile[1845] = new Tile();
			this.tile[1845].image = new Image(getClass().getResourceAsStream("/assets/Pmap/845.png"));
			this.tile[1845].collision = true;

			this.tile[1846] = new Tile();
			this.tile[1846].image = new Image(getClass().getResourceAsStream("/assets/Pmap/846.png"));
			this.tile[1846].collision = true;

			this.tile[1847] = new Tile();
			this.tile[1847].image = new Image(getClass().getResourceAsStream("/assets/Pmap/847.png"));
			this.tile[1847].collision = true;

			this.tile[1848] = new Tile();
			this.tile[1848].image = new Image(getClass().getResourceAsStream("/assets/Pmap/848.png"));
			this.tile[1848].collision = true;

			this.tile[1849] = new Tile();
			this.tile[1849].image = new Image(getClass().getResourceAsStream("/assets/Pmap/849.png"));
			this.tile[1849].collision = true;

			this.tile[1850] = new Tile();
			this.tile[1850].image = new Image(getClass().getResourceAsStream("/assets/Pmap/850.png"));
			this.tile[1850].collision = true;
			
			this.tile[1851] = new Tile();
			this.tile[1851].image = new Image(getClass().getResourceAsStream("/assets/Pmap/851.png"));

			this.tile[1852] = new Tile();
			this.tile[1852].image = new Image(getClass().getResourceAsStream("/assets/Pmap/852.png"));
			this.tile[1852].collision = true;

			this.tile[1853] = new Tile();
			this.tile[1853].image = new Image(getClass().getResourceAsStream("/assets/Pmap/853.png"));
			this.tile[1853].collision = true;

			this.tile[1854] = new Tile();
			this.tile[1854].image = new Image(getClass().getResourceAsStream("/assets/Pmap/854.png"));
			this.tile[1854].collision = true;

			this.tile[1855] = new Tile();
			this.tile[1855].image = new Image(getClass().getResourceAsStream("/assets/Pmap/855.png"));
			this.tile[1855].collision = true;

			this.tile[1856] = new Tile();
			this.tile[1856].image = new Image(getClass().getResourceAsStream("/assets/Pmap/856.png"));
			this.tile[1856].collision = true;

			this.tile[1857] = new Tile();
			this.tile[1857].image = new Image(getClass().getResourceAsStream("/assets/Pmap/857.png"));
			this.tile[1857].collision = true;

			this.tile[1858] = new Tile();
			this.tile[1858].image = new Image(getClass().getResourceAsStream("/assets/Pmap/858.png"));
			this.tile[1858].collision = true;

			this.tile[1859] = new Tile();
			this.tile[1859].image = new Image(getClass().getResourceAsStream("/assets/Pmap/859.png"));
			this.tile[1859].collision = true;

			this.tile[1860] = new Tile();
			this.tile[1860].image = new Image(getClass().getResourceAsStream("/assets/Pmap/860.png"));
			this.tile[1860].collision = true;

			this.tile[1861] = new Tile();
			this.tile[1861].image = new Image(getClass().getResourceAsStream("/assets/Pmap/861.png"));
			this.tile[1861].collision = true;

			this.tile[1862] = new Tile();
			this.tile[1862].image = new Image(getClass().getResourceAsStream("/assets/Pmap/862.png"));
			this.tile[1862].collision = true;

			this.tile[1863] = new Tile();
			this.tile[1863].image = new Image(getClass().getResourceAsStream("/assets/Pmap/863.png"));
			this.tile[1863].collision = true;

			this.tile[1864] = new Tile();
			this.tile[1864].image = new Image(getClass().getResourceAsStream("/assets/Pmap/864.png"));
			this.tile[1864].collision = true;

			this.tile[1865] = new Tile();
			this.tile[1865].image = new Image(getClass().getResourceAsStream("/assets/Pmap/865.png"));
			this.tile[1865].collision = true;

			this.tile[1866] = new Tile();
			this.tile[1866].image = new Image(getClass().getResourceAsStream("/assets/Pmap/866.png"));
			this.tile[1866].collision = true;

			this.tile[1867] = new Tile();
			this.tile[1867].image = new Image(getClass().getResourceAsStream("/assets/Pmap/867.png"));
			this.tile[1867].collision = true;

			this.tile[1868] = new Tile();
			this.tile[1868].image = new Image(getClass().getResourceAsStream("/assets/Pmap/868.png"));
			this.tile[1868].collision = true;

			this.tile[1869] = new Tile();
			this.tile[1869].image = new Image(getClass().getResourceAsStream("/assets/Pmap/869.png"));
			this.tile[1869].collision = true;

			this.tile[1870] = new Tile();
			this.tile[1870].image = new Image(getClass().getResourceAsStream("/assets/Pmap/870.png"));
			this.tile[1870].collision = true;
			
			this.tile[1879] = new Tile();
			this.tile[1879].image = new Image(getClass().getResourceAsStream("/assets/Pmap/879.png"));
			this.tile[1879].collision = true;

			this.tile[1880] = new Tile();
			this.tile[1880].image = new Image(getClass().getResourceAsStream("/assets/Pmap/880.png"));
			this.tile[1880].collision = true;

			this.tile[1881] = new Tile();
			this.tile[1881].image = new Image(getClass().getResourceAsStream("/assets/Pmap/881.png"));
			this.tile[1881].collision = true;

			this.tile[1882] = new Tile();
			this.tile[1882].image = new Image(getClass().getResourceAsStream("/assets/Pmap/882.png"));
			this.tile[1882].collision = true;

			this.tile[1883] = new Tile();
			this.tile[1883].image = new Image(getClass().getResourceAsStream("/assets/Pmap/883.png"));
			this.tile[1883].collision = true;

			this.tile[1884] = new Tile();
			this.tile[1884].image = new Image(getClass().getResourceAsStream("/assets/Pmap/884.png"));
			this.tile[1884].collision = true;

			this.tile[1885] = new Tile();
			this.tile[1885].image = new Image(getClass().getResourceAsStream("/assets/Pmap/885.png"));
			this.tile[1885].collision = true;

			this.tile[1886] = new Tile();
			this.tile[1886].image = new Image(getClass().getResourceAsStream("/assets/Pmap/886.png"));
			this.tile[1886].collision = true;

			this.tile[1887] = new Tile();
			this.tile[1887].image = new Image(getClass().getResourceAsStream("/assets/Pmap/887.png"));
			this.tile[1887].collision = true;

			this.tile[1888] = new Tile();
			this.tile[1888].image = new Image(getClass().getResourceAsStream("/assets/Pmap/888.png"));
			this.tile[1888].collision = true;

			this.tile[1889] = new Tile();
			this.tile[1889].image = new Image(getClass().getResourceAsStream("/assets/Pmap/889.png"));
			this.tile[1889].collision = true;

			this.tile[1890] = new Tile();
			this.tile[1890].image = new Image(getClass().getResourceAsStream("/assets/Pmap/890.png"));
			this.tile[1890].collision = true;

			this.tile[1891] = new Tile();
			this.tile[1891].image = new Image(getClass().getResourceAsStream("/assets/Pmap/891.png"));
			this.tile[1891].collision = true;

			this.tile[1892] = new Tile();
			this.tile[1892].image = new Image(getClass().getResourceAsStream("/assets/Pmap/892.png"));
			this.tile[1892].collision = true;

			this.tile[1893] = new Tile();
			this.tile[1893].image = new Image(getClass().getResourceAsStream("/assets/Pmap/893.png"));
			this.tile[1893].collision = true;

			this.tile[1894] = new Tile();
			this.tile[1894].image = new Image(getClass().getResourceAsStream("/assets/Pmap/894.png"));
			this.tile[1894].collision = true;

			this.tile[1895] = new Tile();
			this.tile[1895].image = new Image(getClass().getResourceAsStream("/assets/Pmap/895.png"));
			this.tile[1895].collision = true;

			this.tile[1896] = new Tile();
			this.tile[1896].image = new Image(getClass().getResourceAsStream("/assets/Pmap/896.png"));
			this.tile[1896].collision = true;

			this.tile[1897] = new Tile();
			this.tile[1897].image = new Image(getClass().getResourceAsStream("/assets/Pmap/897.png"));
			this.tile[1897].collision = true;

			this.tile[1898] = new Tile();
			this.tile[1898].image = new Image(getClass().getResourceAsStream("/assets/Pmap/898.png"));
			this.tile[1898].collision = true;

			this.tile[1899] = new Tile();
			this.tile[1899].image = new Image(getClass().getResourceAsStream("/assets/Pmap/899.png"));
			this.tile[1899].collision = true;

			this.tile[1900] = new Tile();
			this.tile[1900].image = new Image(getClass().getResourceAsStream("/assets/Pmap/900.png"));


			this.tile[0000] = new Tile();
			this.tile[0000].image = new Image(getClass().getResourceAsStream("/assets/Pmap/0.png"));
			this.tile[0000].collision = true;

		} catch (Exception e) {
			System.out.println("Error loading tile images: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			if (is == null) {
				System.out.println("Error: Map file not found: " + filePath);
				return;
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0;
			int row = 0;

			while (col < 50 && row < 50) {
				String line = br.readLine();
				if (line == null) {
					break;
				}

				String[] numbers = line.split(" ");

				for (col = 0; col < numbers.length && col < 50; col++) {
					int num = Integer.parseInt(numbers[col]);

					// ตรวจสอบว่า tile หมายเลขอยู่ในช่วงที่ถูกต้อง
					if (num >= 0 && num < tile.length) {
						this.mapTileNum[col][row] = num;
					} else {
						System.out.println("Warning: Tile ID " + num + " is out of bounds. Skipping...");
						this.mapTileNum[col][row] = 0; // ใช้ tile[0] แทนถ้าหมายเลขผิดพลาด
					}
				}

				col = 0;
				row++;
			}
			br.close();
			System.out.println("Map loaded successfully: " + row + " rows");
		} catch (Exception e) {
			System.out.println("Error loading map: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void draw(GraphicsContext gc) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < 50 && worldRow < 50) {
            int tileNum = this.mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.TILE_SIZE;
            int worldY = worldRow * gp.TILE_SIZE;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            // ตรวจสอบว่า tileNum อยู่ในขอบเขตของอาร์เรย์
            if (tileNum >= 0 && tileNum < tile.length && tile[tileNum] != null && tile[tileNum].image != null) {
                gc.drawImage(this.tile[tileNum].image, screenX, screenY, gp.TILE_SIZE, gp.TILE_SIZE);
            } else {
                // ถ้าไม่มี tile หรือ tileNum ผิดพลาดให้ใช้สี Magenta แทน
                gc.setFill(javafx.scene.paint.Color.MAGENTA);
                gc.fillRect(screenX, screenY, gp.TILE_SIZE, gp.TILE_SIZE);
            }

            worldCol++;

            if (worldCol == 50) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
