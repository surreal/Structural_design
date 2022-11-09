package com.itcm.structural_design.modules.steel.subcategories;

import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.SubCategoriesManagerActivity;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.models.StructuralDesignModel;
import com.itcm.structural_design.modules.steel.SteelCeilingCategory;

import java.util.ArrayList;

public class SteelCeilingSubcategory_One extends SteelCeilingCategory {

    private double id_1001_value = 80, id_1002_value = 5.94, id_1003_value = 42, id_1004_value = 80, id_1005_value = 3.9, id_1006_value = 5.9, id_1007_value = 3.9,
            id_1008_value = 2.3, id_1009_value = 7.57, id_1010_value = 59, id_1012_value = 56, id_1013_value = 58, id_1014_value = 0.3, id_1015_value = 51.09, id_1016_value = 77.8, id_1017_value = 19.5,
            id_1018_value = 22.8, id_1019_value = 3.2, id_1020_value = 3.41, id_1021_value = 6.29, id_1022_value = 3, id_1023_value = 5, id_1024_value = 0.91,
            id_1025_value = 21.6, id_1026_value = 0.87, id_1027_value = 0.09, id_1028_value = 3.559, id_1029_value = 15.487, id_1030_value = 1.905, id_1031_value = 1,id_1032_value = 1,
            id_1101_value = 100, id_1102_value = 8.34, id_1103_value = 50, id_1104_value = 100, id_1105_value = 4.5, id_1106_value = 6.8, id_1107_value = 4.5, id_1108_value = 2.7,
            id_1109_value = 10.6, id_1110_value = 75.7, id_1112_value = 60,  id_1113_value = 68, id_1114_value = 0.37, id_1115_value = 44.47, id_1116_value = 171.0, id_1117_value = 34.2, id_1118_value = 39.8,
            id_1119_value = 4.01, id_1120_value = 4.85, id_1121_value = 12.2, id_1122_value = 4.88, id_1123_value = 8.1, id_1124_value = 1.07, id_1125_value = 25.0,
            id_1126_value = 1.6, id_1127_value = 0.27, id_1128_value = 3.676, id_1129_value = 17.2, id_1130_value = 2.0, id_1131_value = 1, id_1132_value = 1,
            id_1201_value = 120, id_1202_value = 11.1, id_1203_value = 58, id_1204_value = 120, id_1205_value = 5.1, id_1206_value = 7.7, id_1207_value = 5.1,
            id_1208_value = 3.1, id_1209_value = 14.2, id_1210_value = 92.4, id_1212_value = 66,  id_1213_value = 76, id_1214_value = 0.44, id_1215_value = 39.38, id_1216_value = 328.0, id_1217_value = 54.70,
            id_1218_value = 63.60, id_1219_value = 4.81, id_1220_value = 6.63, id_1221_value = 21.40, id_1222_value = 7.41, id_1223_value = 12.40, id_1224_value = 1.23,
            id_1225_value = 28.40, id_1226_value = 2.71, id_1227_value = 0.69, id_1228_value = 3.766, id_1229_value = 18.510, id_1230_value = 2.069, id_1231_value = 1, id_1232_value = 1,
            id_1301_value = 140, id_1302_value = 14.3, id_1303_value = 66, id_1304_value = 140, id_1305_value = 5.7, id_1306_value = 8.6, id_1307_value = 5.7,
            id_1308_value = 3.4, id_1309_value = 18.2, id_1310_value = 109.1, id_1312_value = 80,  id_1313_value = 84, id_1314_value = 0.50, id_1315_value = 34.94, id_1316_value = 573.00, id_1317_value = 81.90,
            id_1318_value = 95.40, id_1319_value = 5.61, id_1320_value = 8.65, id_1321_value = 35.20, id_1322_value = 10.70, id_1323_value = 17.90, id_1324_value = 1.40,
            id_1325_value = 31.80, id_1326_value = 4.32, id_1327_value = 1.54, id_1328_value = 3.837, id_1329_value = 19.544, id_1330_value = 2.121, id_1331_value = 1, id_1332_value = 1,
            id_1401_value = 160, id_1402_value = 17.9, id_1403_value = 74, id_1404_value = 160, id_1405_value = 6.3, id_1406_value = 9.5, id_1407_value = 6.3,
            id_1408_value = 3.8, id_1409_value = 22.8, id_1410_value = 125.8,  id_1412_value = 88,  id_1413_value = 92, id_1414_value = 0.58, id_1415_value = 32.13, id_1416_value = 935.00, id_1417_value = 117.00,
            id_1418_value = 136.00, id_1419_value = 6.40, id_1420_value = 10.83, id_1421_value = 54.70, id_1422_value = 14.80, id_1423_value = 24.90,
            id_1424_value = 1.55, id_1425_value = 35.20, id_1426_value = 6.57, id_1427_value = 3.14, id_1428_value = 3.895, id_1429_value = 20.381, id_1430_value = 2.162, id_1431_value = 1, id_1432_value = 1,
            id_1501_value = 180, id_1502_value = 21.9, id_1503_value = 82, id_1504_value = 180, id_1505_value = 6.9, id_1506_value = 10.4, id_1507_value = 6.9,
            id_1508_value = 4.1, id_1509_value = 27.9, id_1510_value = 142.4, id_1512_value = 100, id_1513_value = 100, id_1514_value = 0.64, id_1515_value = 29.22, id_1516_value = 1450.00, id_1517_value = 161.00,
            id_1518_value = 187.0, id_1519_value = 7.2, id_1520_value = 13.35, id_1521_value = 81.30, id_1522_value = 19.80, id_1523_value = 33.20, id_1524_value = 1.71,
            id_1525_value = 38.60, id_1526_value = 9.58, id_1527_value = 5.92, id_1528_value = 3.942, id_1529_value = 21.072, id_1530_value = 2.195, id_1531_value = 1, id_1532_value = 1,
            id_1601_value = 200, id_1602_value = 26.2, id_1603_value = 90, id_1604_value = 200, id_1605_value = 7.5, id_1606_value = 11.3, id_1607_value = 7.5,
            id_1608_value = 4.5, id_1609_value = 33.4, id_1610_value = 159.1, id_1612_value = 100, id_1613_value = 118, id_1614_value = 0.71, id_1615_value = 27.04, id_1616_value = 2140.0, id_1617_value = 214.00,
            id_1618_value = 250.00, id_1619_value = 8.00, id_1620_value = 16.03, id_1621_value = 117.0, id_1622_value = 26.00, id_1623_value = 43.50, id_1624_value = 187.00,
            id_1625_value = 42.00, id_1626_value = 13.50, id_1627_value = 10.50, id_1628_value = 3.982, id_1629_value = 21.653, id_1630_value = 2.222, id_1631_value = 1, id_1632_value = 1,
            id_1701_value = 220, id_1702_value = 31.1, id_1703_value = 98, id_1704_value = 220, id_1705_value = 8.1, id_1706_value = 12.2, id_1707_value = 8.1,
            id_1708_value = 4.9, id_1709_value = 39.5, id_1710_value = 175.8, id_1711_value = 10, id_1712_value = 50, id_1713_value = 56, id_1714_value = 0.78,
            id_1715_value = 24.99, id_1716_value = 3060.0, id_1717_value = 278.0, id_1718_value = 324.0, id_1719_value = 8.8, id_1720_value = 19.06, id_1721_value = 162.00,
            id_1722_value = 33.10, id_1723_value = 55.70, id_1724_value = 2.02, id_1725_value = 45.40, id_1726_value = 18.60, id_1727_value = 17.80, id_1728_value = 4.016,
            id_1729_value = 22.148, id_1730_value = 2.245, id_1731_value = 1, id_1732_value = 1,
            id_1801_value = 240, id_1802_value = 36.2, id_1803_value = 106, id_1804_value = 240, id_1805_value = 8.7, id_1806_value = 13.1, id_1807_value = 8.7,
            id_1808_value = 5.2, id_1809_value = 46.1, id_1810_value = 192.5, id_1811_value = 10, id_1812_value = 54, id_1813_value = 60, id_1814_value = 0.84,
            id_1815_value = 23.32, id_1816_value = 4250.00, id_1817_value = 354.00, id_1818_value = 412.00, id_1819_value = 9.59, id_1820_value = 22.33,
            id_1821_value = 221.00, id_1822_value = 41.70, id_1823_value = 70.00, id_1824_value = 2.20, id_1825_value = 48.90, id_1826_value = 25.00,
            id_1827_value = 28.70, id_1828_value = 4.046, id_1829_value = 22.575, id_1830_value = 2.264, id_1831_value = 1, id_1832_value = 1,
            id_1901_value = 260, id_1902_value = 41.9, id_1903_value = 113, id_1904_value = 260, id_1905_value = 9.4, id_1906_value = 14.1, id_1907_value = 9.4,
            id_1908_value = 5.6, id_1909_value = 53.3, id_1910_value = 208.9, id_1911_value = 12, id_1912_value = 62, id_1913_value = 62, id_1914_value = 0.91,
            id_1915_value = 21.65, id_1916_value = 5740.00, id_1917_value = 442.00, id_1918_value = 514.0, id_1919_value = 10.4, id_1920_value = 26.08,
            id_1921_value = 288.0, id_1922_value = 51.00, id_1923_value = 85.90, id_1924_value = 2.32, id_1925_value = 52.60, id_1926_value = 33.50,
            id_1927_value = 44.10, id_1928_value = 4.007, id_1929_value = 22.660, id_1930_value = 2.301, id_1931_value = 1, id_1932_value = 1,
            id_2001_value = 280, id_2002_value = 47.9, id_2003_value = 119, id_2004_value = 280, id_2005_value = 10.1, id_2006_value = 15.2, id_2007_value = 10.1,
            id_2008_value = 6.1, id_2009_value = 61, id_2010_value = 225.1, id_2011_value = 12, id_2012_value = 68, id_2013_value = 68, id_2014_value = 0.97,
            id_2015_value = 20.17, id_2016_value = 7590.0, id_2017_value = 542.0, id_2018_value = 632.0, id_2019_value = 11.1, id_2020_value = 30.18, id_2021_value = 364.0,
            id_2022_value = 61.2, id_2023_value = 103.0, id_2024_value = 2.45, id_2025_value = 56.4, id_2026_value = 44.2, id_2027_value = 64.6, id_2028_value = 3.914,
            id_2029_value = 22.713, id_2030_value = 2.353, id_2031_value = 1, id_2032_value = 1,
            id_2101_value = 300, id_2102_value = 54.2, id_2103_value = 125, id_2104_value = 300, id_2105_value = 10.8, id_2106_value = 16.2, id_2107_value = 10.8,
            id_2108_value = 6.5, id_2109_value = 69, id_2110_value = 241.6, id_2111_value = 12, id_2112_value = 70, id_2113_value = 74, id_2114_value = 1.03,
            id_2115_value = 19.02, id_2116_value = 9800.0, id_2117_value = 653.0, id_2118_value = 762.0, id_2119_value = 11.9, id_2120_value = 34.58,
            id_2121_value = 451.0, id_2122_value = 72.2, id_2123_value = 121.0, id_2124_value = 2.56, id_2125_value = 60.1, id_2126_value = 56.8, id_2127_value = 91.8,
            id_2128_value = 3.858, id_2129_value = 22.778, id_2130_value = 2.4, id_2131_value = 1, id_2132_value = 1,
            id_2201_value = 320, id_2202_value = 61, id_2203_value = 131, id_2204_value = 320, id_2205_value = 11.5, id_2206_value = 17.3, id_2207_value = 11.5,
            id_2208_value = 6.9, id_2209_value = 77.7, id_2210_value = 257.9, id_2211_value = 12, id_2212_value = 70, id_2213_value = 80, id_2214_value = 1.09,
            id_2215_value = 17.87, id_2216_value = 12510.0, id_2217_value = 782.0, id_2218_value = 914.0, id_2219_value = 12.7, id_2220_value = 39.26,
            id_2221_value = 555.0, id_2222_value = 84.7, id_2223_value = 143.0, id_2224_value = 2.67, id_2225_value = 63.9, id_2226_value = 72.5, id_2227_value = 129.0,
            id_2228_value = 3.786, id_2229_value = 22.817, id_2230_value = 2.443, id_2231_value = 1, id_2232_value = 1,
            id_2301_value = 340, id_2302_value = 68, id_2303_value = 137, id_2304_value = 340, id_2305_value = 12.2, id_2306_value = 18.3, id_2307_value = 12.2,
            id_2308_value = 7.3, id_2309_value = 86.7, id_2310_value = 274.3, id_2311_value = 12, id_2312_value = 78, id_2313_value = 86, id_2314_value = 1.15,
            id_2315_value = 16.9, id_2316_value = 15700.0, id_2317_value = 923.0, id_2318_value = 1080.0, id_2319_value = 13.5, id_2320_value = 44.27,
            id_2321_value = 674.0, id_2322_value = 98.4, id_2323_value = 166.0, id_2324_value = 2.8, id_2325_value = 67.6, id_2326_value = 90.4, id_2327_value = 176.0,
            id_2328_value = 3.743, id_2329_value = 22.869, id_2330_value = 2.482, id_2331_value = 1, id_2332_value = 1,
            id_2401_value = 360, id_2402_value = 76.1, id_2403_value = 143, id_2404_value = 360, id_2405_value = 13, id_2406_value = 19.5, id_2407_value = 13,
            id_2408_value = 7.8, id_2409_value = 97, id_2410_value = 290, id_2411_value = 12, id_2412_value = 78, id_2413_value = 92, id_2414_value = 1.21,
            id_2415_value = 15.89, id_2416_value = 19610.0, id_2417_value = 1090.0, id_2418_value = 1276.0, id_2419_value = 14.2, id_2420_value = 49.95,
            id_2421_value = 818.0, id_2422_value = 114.0, id_2423_value = 194.0, id_2424_value = 2.9, id_2425_value = 71.8, id_2426_value = 115.0, id_2427_value = 240.0,
            id_2428_value = 3.667, id_2429_value = 22.692, id_2430_value = 2.517, id_2431_value = 1, id_2432_value = 1,
            id_2501_value = 380, id_2502_value = 84, id_2503_value = 149, id_2504_value = 380, id_2505_value = 13.7, id_2506_value = 20.5, id_2507_value = 13.7,
            id_2508_value = 8.2, id_2509_value = 107, id_2510_value = 306.7, id_2511_value = 16, id_2512_value = 84, id_2513_value = 86, id_2514_value = 1.27,
            id_2515_value = 15.12, id_2516_value = 24010.0, id_2517_value = 1260.0, id_2518_value = 1482.0, id_2519_value = 15.0, id_2520_value = 55.55,
            id_2521_value = 975.0, id_2522_value = 131.0, id_2523_value = 221.0, id_2524_value = 3.02, id_2525_value = 75.4, id_2526_value = 141.0,
            id_2527_value = 319.0, id_2528_value = 3.634, id_2529_value = 22.745, id_2530_value = 2.55, id_2531_value = 1, id_2532_value = 1,
            id_2601_value = 400, id_2602_value = 92.4, id_2603_value = 155, id_2604_value = 400, id_2605_value = 14.4, id_2606_value = 21.6, id_2607_value = 14.4,
            id_2608_value = 8.6, id_2609_value = 118, id_2610_value = 322.9, id_2611_value = 16, id_2612_value = 86, id_2613_value = 92, id_2614_value = 1.33,
            id_2615_value = 14.36, id_2616_value = 29210.0, id_2617_value = 1460.0, id_2618_value = 1714.0, id_2619_value = 15.7, id_2620_value = 61.69,
            id_2621_value = 1160.0, id_2622_value = 149.0, id_2623_value = 253.0, id_2624_value = 3.13, id_2625_value = 79.3, id_2626_value = 170.0, id_2627_value = 420.0,
            id_2628_value = 3.588, id_2629_value = 22.778, id_2630_value = 2.581, id_2631_value = 1, id_2632_value = 1,
            id_2701_value = 450, id_2702_value = 115, id_2703_value = 170, id_2704_value = 450, id_2705_value = 16.2, id_2706_value = 24.3, id_2707_value = 16.2,
            id_2708_value = 9.7, id_2709_value = 147, id_2710_value = 363.6, id_2711_value = 16, id_2712_value = 92, id_2713_value = 106, id_2714_value = 1.48,
            id_2715_value = 12.83, id_2716_value = 45850.0, id_2717_value = 2040.0, id_2718_value = 2400.0, id_2719_value = 17.7, id_2720_value = 77.79,
            id_2721_value = 1730.0, id_2722_value = 203.0, id_2723_value = 345.0, id_2724_value = 3.43, id_2725_value = 88.9, id_2726_value = 267.0,
            id_2727_value = 791.0, id_2728_value = 3.498, id_2729_value = 22.778, id_2730_value = 2.647, id_2731_value = 1, id_2732_value = 1,
            id_2801_value = 500, id_2802_value = 141, id_2803_value = 185, id_2804_value = 500, id_2805_value = 18, id_2806_value = 27, id_2807_value = 18,
            id_2808_value = 10.8, id_2809_value = 179, id_2810_value = 404.3, id_2811_value = 20, id_2812_value = 102, id_2813_value = 110, id_2814_value = 1.63,
            id_2815_value = 11.6, id_2816_value = 68740.0, id_2817_value = 2750.0, id_2818_value = 3240.0, id_2819_value = 19.6, id_2820_value = 95.6,
            id_2821_value = 2480.0, id_2822_value = 268.0, id_2823_value = 456.0, id_2824_value = 3.72, id_2825_value = 98.5, id_2826_value = 402.0,
            id_2827_value = 1400.0, id_2828_value = 3.426, id_2829_value = 22.778, id_2830_value = 2.703, id_2831_value = 1, id_2832_value = 1,
            id_2901_value = 550, id_2902_value = 166, id_2903_value = 200, id_2904_value = 550, id_2905_value = 19, id_2906_value = 30, id_2907_value = 19,
            id_2908_value = 11.9, id_2909_value = 212, id_2910_value = 445.6, id_2911_value = 22, id_2912_value = 112, id_2913_value = 118, id_2914_value = 1.80,
            id_2915_value = 10.8, id_2916_value = 99180.0, id_2917_value = 3610.0, id_2918_value = 4240.0, id_2919_value = 21.6, id_2920_value = 111.3,
            id_2921_value = 3490.0, id_2922_value = 349.0, id_2923_value = 592.0, id_2924_value = 4.02, id_2925_value = 107.3, id_2926_value = 544.0,
            id_2927_value = 2390.0, id_2928_value = 3.333, id_2929_value = 23.789, id_2930_value = 2.75, id_2931_value = 1, id_2932_value = 1,
            id_3001_value = 600, id_3002_value = 199, id_3003_value = 215, id_3004_value = 600, id_3005_value = 21.6, id_3006_value = 32.4,
            id_3007_value = 21.6, id_3008_value = 13, id_3009_value = 254, id_3010_value = 485.8, id_3011_value = 24, id_3012_value = 126, id_3013_value = 128,
            id_3014_value = 192.0, id_3015_value = 9.89, id_3016_value = 139000.0, id_3017_value = 4630.0, id_3018_value = 5452.0, id_3019_value = 23.4,
            id_3020_value = 138.0, id_3021_value = 4670.0, id_3022_value = 434.0, id_3023_value = 752.0, id_3024_value = 4.3, id_3025_value = 117.6,
            id_3026_value = 787.0, id_3027_value = 3814.0, id_3028_value = 3.318, id_3029_value = 22.778, id_3030_value = 2.791, id_3031_value = 1, id_3032_value = 1,
            id_3101_value = 600, id_3102_value = 199, id_3103_value = 215, id_3104_value = 600, id_3105_value = 21.6, id_3106_value = 32.4,
            id_3107_value = 21.6, id_3108_value = 13, id_3109_value = 254, id_3110_value = 485.8, id_3111_value = 24, id_3112_value = 126, id_3113_value = 128,
            id_3114_value = 192.0, id_3115_value = 9.89, id_3116_value = 139000.0, id_3117_value = 4631.0, id_3118_value = 5452.0, id_3119_value = 23.4,
            id_3120_value = 138.0, id_3121_value = 4670.0, id_3122_value = 434.0, id_3123_value = 752.0, id_3124_value = 4.3, id_3125_value = 117.6,
            id_3126_value = 787.0, id_3127_value = 3814.0, id_3128_value = 3.318, id_3129_value = 22.778, id_3130_value = 2.791,  id_3131_value = 2.791, id_3132_value = 1,
            id_3201_value = 600, id_3202_value = 199, id_3203_value = 215, id_3204_value = 600, id_3205_value = 21.6, id_3206_value = 32.4,
            id_3207_value = 21.6, id_3208_value = 13, id_3209_value = 254, id_3210_value = 485.8, id_3211_value = 24, id_3212_value = 126, id_3213_value = 128,
            id_3214_value = 192.0, id_3215_value = 9.89, id_3216_value = 139000.0, id_3217_value = 4632.0, id_3218_value = 5452.0, id_3219_value = 23.4,
            id_3220_value = 138.0, id_3221_value = 4670.0, id_3222_value = 434.0, id_3223_value = 752.0, id_3224_value = 4.3, id_3225_value = 117.6,
            id_3226_value = 787.0, id_3227_value = 3814.0, id_3228_value = 3.328, id_3229_value = 22.778, id_3230_value = 2.791, id_3231_value = 1, id_3232_value = 1,
            id_3301_value = 600, id_3302_value = 199, id_3303_value = 215, id_3304_value = 600, id_3305_value = 21.6, id_3306_value = 32.4,
            id_3307_value = 21.6, id_3308_value = 13, id_3309_value = 254, id_3310_value = 485.8, id_3311_value = 24, id_3312_value = 126, id_3313_value = 128,
            id_3314_value = 192.0, id_3315_value = 9.89, id_3316_value = 139000.0, id_3317_value = 4633.0, id_3318_value = 5452.0, id_3319_value = 23.4,
            id_3320_value = 138.0, id_3321_value = 4670.0, id_3322_value = 434.0, id_3323_value = 752.0, id_3324_value = 4.3, id_3325_value = 117.6,
            id_3326_value = 787.0, id_3327_value = 3814.0, id_3328_value = 3.328, id_3329_value = 22.778, id_3330_value = 2.791, id_3331_value = 2.791, id_3332_value = 1;
    private ArrayList<Double> keysAList, valuesOfColumn_3_AList, valuesOfColumn_4_AList, valuesOfColumn_5_AList, valuesOfColumn_6_AList, valuesOfColumn_7_AList,
            valuesOfColumn_9_AList, valuesOfColumn_16_AList, valuesOfColumn_17_AList, valuesOfColumn_18_AList, valuesOfColumn_19_AList, valuesOfColumn_21_AList,
            valuesOfColumn_24_AList, valuesOfColumn_31_AList, valuesOfColumn_32_AList;

    public SteelCeilingSubcategory_One(){
        setValues();
        setAllAdapters();
        Log.d("checkModuleCategorySubcategory", "moduleActiveId == " + moduleActiveId + "; categoryActiveId == " + categoryActiveId + "; subCategoryActiveId == " + subCategoryActiveId);
    }

    private void setValues() {
        setRelevantTableValues();
        setSeriesValuesALists();
        setSecondaryTitles();

        cursor = sqlLocal.selectFiveComparesCursor("*", savedVersionTitle);
        if (cursor.moveToFirst()) {
            id_1_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_1);
            id_1_position = getPositionByValue(subCategoryActiveId == 0 ? getIPN_stringValues() : getHebAndHea_stringValues(), id_1_value);
            id_14_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_14);
            id_14_position = getPositionByValue(getSteelType_stringValues(), id_14_value);
            id_15_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_15);
            id_17_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_17);
            id_21_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_21);
            id_22_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_22);
            id_23_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_23);
            id_27_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_27);
            id_43_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_43);
            id_44_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_44);
            id_47_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_47_POSITION);
            id_55_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_55);
            id_56_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_56);
            id_59_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_59_POSITION);
            id_66_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_66);
            id_71_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_71);
            id_72_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_72);
            Log.d("checkSetValues", "id_14_value == " + id_14_value + "; id_14_position == " + id_14_position);
        } else { resetValues(); }
        spinnerPositionsArray = new ArrayMap<>();
        spinnerPositionsArray.put(1, id_1_position);
        spinnerPositionsArray.put(14, id_14_position);
        spinnerPositionsArray.put(47, id_47_position);
        spinnerPositionsArray.put(59, id_59_position);

    }

    private void setRelevantTableValues() {
        switch (subCategoryActiveId){
            case 0:
                setFirstTableValues();
                break;
            case 1:
                setSecondTableValues();
                break;
            case 2:
                setThirdTableValues();
                break;
        }
    }

    private void setSecondaryTitles() {
        secondaryTitles = new ArrayList<>();
        secondaryTitles.add("תכונות החתך");
        secondaryTitles.add("סוג הפלדה");
        secondaryTitles.add("תסבולת ללחיצה בהתחשב בקריסה אוילרית");
        secondaryTitles.add("תסבולת לגזירה");
        secondaryTitles.add("תסבולת לכפיפה (עבור D/tw<68)");
        secondaryTitles.add("בדיקה משולבת כוח צירי ומומנט כפיפה");
        secondaryTitles.add("תסבולת לחיצה עקב קריסה לציר Y");
        secondaryTitles.add("תסבולת לחיצה עקב קריסה לציר X");
        secondaryTitles.add("תסבולת לכפיפה בהתחשב בקריסה צידית");
        secondaryTitles.add("בדיקת יציבות -עמוד קורה");
    }

    public View.OnClickListener onSaveClickListener = view -> insertOrUpdateVersion(savedVersionTitle == null);

    public void insertOrUpdateVersion(boolean isForInsert) {
        if (!isForInsert){
            updateDB();
            activity.finish();
            return;
        }
        dialogHelper.initInputDialog(view1 -> {
            Log.d("checkDialogBtnClicked", "categoryActiveId == " + categoryActiveId + "; subCategoryActiveId == " + subCategoryActiveId + "; DialogHelper.input == " + DialogHelper.input + "; cursor.getCount() == " + cursor.getCount() + "; cursor.moveToFirst() == " + cursor.moveToFirst());
            if (setDialogInputReturnMsgIfErr()) return;
            insertToDB();
            dialog.dismiss();
            activity.finish();
        });
    }

    private void setThirdTableValues() {
        id_1_value = 100;
        id_1001_value = 100; id_1002_value = 16.7; id_1003_value = 100; id_1004_value = 96; id_1005_value = 5; id_1006_value = 8; id_1007_value = 12;
        id_1008_value = 21.2; id_1009_value = 80; id_1010_value = 56; id_1012_value = 54; id_1013_value = 58; id_1014_value = 0.5610; id_1015_value = 33.68;
        id_1016_value = 349.2; id_1017_value = 72.76; id_1018_value = 83.01; id_1019_value = 4.06; id_1020_value = 7.56; id_1021_value = 133.8; id_1022_value = 26.76;
        id_1023_value = 41.14; id_1024_value = 2.51;id_1025_value = 35.06; id_1026_value = 5.24; id_1027_value = 2.58; id_1028_value = 6.250; id_1029_value = 11.2;
        id_1030_value = 0.960; id_1031_value = 0.001; id_1032_value = 0.001;
        id_1101_value = 120; id_1102_value = 19.9; id_1103_value = 120; id_1104_value = 114; id_1105_value = 5; id_1106_value = 8; id_1107_value = 12;
        id_1108_value = 25.3; id_1109_value = 98; id_1110_value = 74; id_1112_value = 58; id_1113_value = 68; id_1114_value = 0.6770; id_1115_value = 34.06;
        id_1116_value = 606.2; id_1117_value = 106.3; id_1118_value = 119.5; id_1119_value = 4.89; id_1120_value = 8.46; id_1121_value = 230.9; id_1122_value = 38.48;
        id_1123_value = 58.85; id_1124_value = 3.02; id_1125_value = 35.06; id_1126_value = 5.99; id_1127_value = 6.47;id_1128_value = 7.500; id_1129_value = 14.800;
        id_1130_value = 0.950; id_1131_value = 0.001; id_1132_value = 0.001;
        id_1201_value = 140; id_1202_value = 24.7; id_1203_value = 140; id_1204_value = 133; id_1205_value = 5.5; id_1206_value = 8.5; id_1207_value = 12;
        id_1208_value = 31.4; id_1209_value = 116; id_1210_value = 92; id_1212_value = 64; id_1213_value = 76; id_1214_value = 0.7940; id_1215_value = 32.21;
        id_1216_value = 1033; id_1217_value = 155.4; id_1218_value = 173.5; id_1219_value = 5.73; id_1220_value = 10.12; id_1221_value = 389.3; id_1222_value = 55.62;
        id_1223_value = 84.85; id_1224_value = 3.52; id_1225_value = 36.56; id_1226_value = 8.13; id_1227_value = 15.06; id_1228_value = 8.235; id_1229_value = 16.727;
        id_1230_value = 0.950; id_1231_value = 0.001; id_1232_value = 0.002;
        id_1301_value = 160; id_1302_value = 30.4; id_1303_value = 160; id_1304_value = 152; id_1305_value = 6; id_1306_value = 9; id_1307_value = 15;
        id_1308_value = 38.8; id_1309_value = 134; id_1310_value = 104; id_1312_value = 78; id_1313_value = 84; id_1314_value = 0.9060; id_1315_value = 29.78;
        id_1316_value = 1673; id_1317_value = 220.1; id_1318_value = 245.1; id_1319_value = 6.57; id_1320_value = 13.21; id_1321_value = 615.6;id_1322_value = 76.95;
        id_1323_value = 117.6; id_1324_value = 3.98; id_1325_value = 41.57; id_1326_value = 12.19; id_1327_value = 31.41; id_1328_value = 8.889; id_1329_value = 17.333;
        id_1330_value = 0.950; id_1331_value = 0.002; id_1332_value = 0.004;
        id_1401_value = 180; id_1402_value = 35.5; id_1403_value = 180; id_1404_value = 171; id_1405_value = 6; id_1406_value = 9.5; id_1407_value = 15;
        id_1408_value = 45.3;id_1409_value = 152; id_1410_value = 122; id_1412_value = 86; id_1413_value = 92; id_1414_value = 1.0240; id_1415_value = 28.83;
        id_1416_value = 2510;id_1417_value = 293.6; id_1418_value = 324.9; id_1419_value = 7.45; id_1420_value = 14.47; id_1421_value = 924.6; id_1422_value = 102.7;
        id_1423_value = 154.5; id_1424_value = 4.52; id_1425_value = 42.57; id_1426_value = 14.8; id_1427_value = 60.21; id_1428_value = 9.474; id_1429_value = 20.333;
        id_1430_value = 0.950; id_1431_value = 0.002; id_1432_value = 0.007;
        id_1501_value = 200; id_1502_value = 42.3; id_1503_value = 200; id_1504_value = 190; id_1505_value = 6.5; id_1506_value = 10; id_1507_value = 18;
        id_1508_value = 53.8; id_1509_value = 170; id_1510_value = 134; id_1512_value = 98; id_1513_value = 100; id_1514_value = 1.136; id_1515_value = 26.89;
        id_1516_value = 3692; id_1517_value = 388.6;id_1518_value = 429.5; id_1519_value = 8.28; id_1520_value = 18.08; id_1521_value = 1336; id_1522_value = 133.6;
        id_1523_value = 203.8; id_1524_value = 4.98;id_1525_value = 47.59; id_1526_value = 20.98; id_1527_value = 108.0; id_1528_value = 10.000; id_1529_value = 20.615;
        id_1530_value = 0.950; id_1531_value = 0.003; id_1532_value = 0.012;
        id_1601_value = 220; id_1602_value = 50.5; id_1603_value = 220; id_1604_value = 210; id_1605_value = 7; id_1606_value = 11; id_1607_value = 18;
        id_1608_value = 64.3; id_1609_value = 188; id_1610_value = 152; id_1612_value = 98; id_1613_value = 118; id_1614_value = 1.2550; id_1615_value = 24.85;
        id_1616_value = 5410; id_1617_value = 515.2; id_1618_value = 568.5; id_1619_value = 9.17; id_1620_value = 20.67; id_1621_value = 1955; id_1622_value = 177.7;
        id_1623_value = 270.6; id_1624_value = 5.51; id_1625_value = 50.09; id_1626_value = 28.46; id_1627_value = 193.3; id_1628_value = 10.000; id_1629_value = 21.714;
        id_1630_value = 0.955; id_1631_value = 0.005; id_1632_value = 0.019;
        id_1701_value = 240; id_1702_value = 60.3; id_1703_value = 240; id_1704_value = 230; id_1705_value = 7.5; id_1706_value = 12; id_1707_value = 21;
        id_1708_value = 76.8; id_1709_value = 206; id_1710_value = 164; id_1712_value = 104; id_1713_value = 138; id_1714_value = 1.3690;
        id_1715_value = 22.70; id_1716_value = 7763; id_1717_value = 675.1; id_1718_value = 744.6; id_1719_value = 10.05; id_1720_value = 25.18; id_1721_value = 2769;
        id_1722_value = 230.7; id_1723_value = 351.7; id_1724_value = 6; id_1725_value = 56.10; id_1726_value = 41.55; id_1727_value = 328.5; id_1728_value = 10.0;
        id_1729_value = 21.867; id_1730_value = 0.958; id_1731_value = 0.007; id_1732_value = 0.030;
        id_1801_value = 260; id_1802_value = 68.2; id_1803_value = 260; id_1804_value = 250; id_1805_value = 7.5; id_1806_value = 12.5; id_1807_value = 24;
        id_1808_value = 86.8; id_1809_value = 225; id_1810_value = 177; id_1812_value = 110; id_1813_value = 158; id_1814_value = 1.4860;
        id_1815_value = 21.77; id_1816_value = 10450; id_1817_value = 836.4; id_1818_value = 919.8; id_1819_value = 10.97; id_1820_value = 28.76;
        id_1821_value = 3668; id_1822_value = 282.1; id_1823_value = 430.2; id_1824_value = 6.5; id_1825_value = 60.62; id_1826_value = 52.37;
        id_1827_value = 516.4; id_1828_value = 10.4; id_1829_value = 23.600; id_1830_value = 0.962; id_1831_value = 0.009; id_1832_value = 0.043;
        id_1901_value = 280; id_1902_value = 76.4; id_1903_value = 280; id_1904_value = 270; id_1905_value = 8; id_1906_value = 13; id_1907_value = 24;
        id_1908_value = 97.3; id_1909_value = 244; id_1910_value = 196; id_1912_value = 112; id_1913_value = 178; id_1914_value = 1.6030;
        id_1915_value = 20.99; id_1916_value = 13670; id_1917_value = 1013; id_1918_value = 1112; id_1919_value = 11.86; id_1920_value = 31.74;
        id_1921_value = 4763; id_1922_value = 340.2; id_1923_value = 518.1; id_1924_value = 1; id_1925_value = 62.12; id_1926_value = 62.1;
        id_1927_value = 785.4; id_1928_value = 10.769; id_1929_value = 24.500; id_1930_value = 0.964; id_1931_value = 0.011; id_1932_value = 0.060;
        id_2001_value = 300; id_2002_value = 88.3; id_2003_value = 300; id_2004_value = 290; id_2005_value = 8.5; id_2006_value = 14; id_2007_value = 27;
        id_2008_value = 112.5; id_2009_value = 262; id_2010_value = 208; id_2012_value = 118; id_2013_value = 198; id_2014_value = 1.7170;
        id_2015_value = 19.43; id_2016_value = 18260; id_2017_value = 1260; id_2018_value = 1383; id_2019_value = 12.74; id_2020_value = 37.28; id_2021_value = 6310;
        id_2022_value = 420.6; id_2023_value = 641.2; id_2024_value = 7.49; id_2025_value = 68.13; id_2026_value = 85.17; id_2027_value = 1200; id_2028_value = 10.714;
        id_2029_value = 24.471; id_2030_value = 0.967; id_2031_value = 0.014; id_2032_value = 0.086;
        id_2101_value = 320; id_2102_value = 97.6; id_2103_value = 300; id_2104_value = 310; id_2105_value = 9; id_2106_value = 15.5; id_2107_value = 27;
        id_2108_value = 124.4; id_2109_value = 279; id_2110_value = 225; id_2112_value = 118; id_2113_value = 198; id_2114_value = 1.756;
        id_2115_value = 17.98; id_2116_value = 22930; id_2117_value = 1479; id_2118_value = 1628; id_2119_value = 13.58; id_2120_value = 41.13;
        id_2121_value = 6985; id_2122_value = 465; id_2123_value = 709.7; id_2124_value = 7.49; id_2125_value = 71.63; id_2126_value = 108; id_2127_value = 1512;
        id_2128_value = 9.677; id_2129_value = 25.0; id_2130_value = 1.033; id_2131_value = 0.017; id_2132_value = 0.102;
        id_2201_value = 340; id_2202_value = 105; id_2203_value = 300; id_2204_value = 330; id_2205_value = 9.5; id_2206_value = 16.5; id_2207_value = 27;
        id_2208_value = 133.5; id_2209_value = 297; id_2210_value = 243; id_2212_value = 118; id_2213_value = 198; id_2214_value = 1.7950;
        id_2215_value = 17.13; id_2216_value = 27690; id_2217_value = 1678; id_2218_value = 1850; id_2219_value = 14.4; id_2220_value = 44.95;
        id_2221_value = 7436; id_2222_value = 495.87; id_2223_value = 755.9; id_2224_value = 7.46; id_2225_value = 74.13; id_2226_value = 127.2; id_2227_value = 1824;
        id_2228_value = 9.091; id_2229_value = 25.579; id_2230_value = 1.100; id_2231_value = 0.019; id_2232_value = 0.115;
        id_2301_value = 360; id_2302_value = 112; id_2303_value = 300; id_2304_value = 350; id_2305_value = 10; id_2306_value = 17.5; id_2307_value = 27;
        id_2308_value = 142.8; id_2309_value = 315; id_2310_value = 261; id_2312_value = 120; id_2313_value = 198; id_2314_value = 1.8340;
        id_2315_value = 16.36; id_2316_value = 33090; id_2317_value = 1891; id_2318_value = 2088; id_2319_value = 15.22; id_2320_value = 48.96;
        id_2321_value = 7887; id_2322_value = 525.8; id_2323_value = 802.3; id_2324_value = 7.43; id_2325_value = 76.63; id_2326_value = 148.8; id_2327_value = 2177;
        id_2328_value = 8.571; id_2329_value = 26.1; id_2330_value = 1.167; id_2331_value = 0.021; id_2332_value = 0.129;
        id_2401_value = 400; id_2402_value = 125; id_2403_value = 300; id_2404_value = 390; id_2405_value = 11; id_2406_value = 19; id_2407_value = 27;
        id_2408_value = 159; id_2409_value = 352; id_2410_value = 298; id_2412_value = 120; id_2413_value = 198; id_2414_value = 1.912;
        id_2415_value = 15.32; id_2416_value = 45070; id_2417_value = 2311; id_2418_value = 2562; id_2419_value = 16.84; id_2420_value = 57.33;
        id_2421_value = 8564; id_2422_value = 570.9; id_2423_value = 872.9; id_2424_value = 7.34; id_2425_value = 80.63; id_2426_value = 189; id_2427_value = 2942;
        id_2428_value = 7.895; id_2429_value = 27.091; id_2430_value = 1.3; id_2431_value = 0.025; id_2432_value = 0.157;
        id_2501_value = 450; id_2502_value = 140; id_2503_value = 300; id_2504_value = 440; id_2505_value = 11.5; id_2506_value = 21; id_2507_value = 27;
        id_2508_value = 178; id_2509_value = 398; id_2510_value = 344; id_2512_value = 122; id_2513_value = 198; id_2514_value = 2.011;
        id_2515_value = 14.39; id_2516_value = 63720; id_2517_value = 2896; id_2518_value = 3216; id_2519_value = 18.92; id_2520_value = 65.78;
        id_2521_value = 9465; id_2522_value = 631; id_2523_value = 965.5; id_2524_value = 7.29; id_2525_value = 85.13; id_2526_value = 243.8;
        id_2527_value = 4148; id_2528_value = 7.143; id_2529_value = 29.913; id_2530_value = 1.467; id_2531_value = 0.03; id_2532_value = 0.196;
        id_2601_value = 500; id_2602_value = 155; id_2603_value = 300; id_2604_value = 490; id_2605_value = 12; id_2606_value = 23; id_2607_value = 27;
        id_2608_value = 197.5; id_2609_value = 444; id_2610_value = 390; id_2612_value = 122; id_2613_value = 198; id_2614_value = 2.11;
        id_2615_value = 13.60; id_2616_value = 86970; id_2617_value = 3550; id_2618_value = 3949; id_2619_value = 20.98; id_2620_value = 74.72;
        id_2621_value = 10370; id_2622_value = 691; id_2623_value = 1059; id_2624_value = 7.24; id_2625_value = 89.63; id_2626_value = 309.3; id_2627_value = 5643;
        id_2628_value = 6.522; id_2629_value = 32.500; id_2630_value = 1.633; id_2631_value = 0.035; id_2632_value = 0.239;
        id_2701_value = 550; id_2702_value = 166; id_2703_value = 300; id_2704_value = 540; id_2705_value = 12.5; id_2706_value = 24; id_2707_value = 27;
        id_2708_value = 211.8; id_2709_value = 492; id_2710_value = 438; id_2712_value = 122; id_2713_value = 198; id_2714_value = 2.209;
        id_2715_value = 13.29; id_2716_value = 111900; id_2717_value = 4146; id_2718_value = 4622; id_2719_value = 22.99; id_2720_value = 83.72;
        id_2721_value = 10820; id_2722_value = 721.3; id_2723_value = 1107; id_2724_value = 7.15; id_2725_value = 92.13; id_2726_value = 351.5;
        id_2727_value = 7189; id_2728_value = 6.250; id_2729_value = 35.040; id_2730_value = 1.800; id_2731_value = 0.038; id_2732_value = 0.276;
        id_2801_value = 600; id_2802_value = 178; id_2803_value = 300; id_2804_value = 590; id_2805_value = 13; id_2806_value = 25; id_2807_value = 27;
        id_2808_value = 226.5; id_2809_value = 540; id_2810_value = 486; id_2812_value = 122; id_2813_value = 198; id_2814_value = 2.308;
        id_2815_value = 12.98; id_2816_value = 141200; id_2817_value = 4787; id_2818_value = 5350; id_2819_value = 24.97; id_2820_value = 93.21;
        id_2821_value = 11270; id_2822_value = 751.4; id_2823_value = 1156; id_2824_value = 7.05; id_2825_value = 94.63; id_2826_value = 397.8;
        id_2827_value = 8978; id_2828_value = 6.0; id_2829_value = 37.385; id_2830_value = 1.967; id_2831_value = 0.041; id_2832_value = 0.314;
        id_2901_value = 650; id_2902_value = 190; id_2903_value = 300; id_2904_value = 640; id_2905_value = 13.5; id_2906_value = 26; id_2907_value = 27;
        id_2908_value = 241.6; id_2909_value = 588; id_2910_value = 534; id_2912_value = 124; id_2913_value = 198; id_2914_value = 2.407;id_2915_value = 12.69;
        id_2916_value = 175200; id_2917_value = 5474; id_2918_value = 6136; id_2919_value = 26.93; id_2920_value = 103.2; id_2921_value = 11720;
        id_2922_value = 781.6; id_2923_value = 1205; id_2924_value = 6.97; id_2925_value = 97.13; id_2926_value = 448.3; id_2927_value = 11030;
        id_2928_value = 5.769; id_2929_value = 39.556; id_2930_value = 2.133; id_2931_value = 0.045; id_2932_value = 0.355;
        id_3001_value = 700; id_3002_value = 204; id_3003_value = 300; id_3004_value = 690; id_3005_value = 14.5; id_3006_value = 27; id_3007_value = 27;
        id_3008_value = 260.5; id_3009_value = 636; id_3010_value = 582; id_3012_value = 124; id_3013_value = 198; id_3014_value = 2.505; id_3015_value = 12.25;
        id_3016_value = 215300; id_3017_value = 6241; id_3018_value = 7032; id_3019_value = 28.75; id_3020_value = 117.0; id_3021_value = 12180;
        id_3022_value = 811.6; id_3023_value = 1257; id_3024_value = 6.84; id_3025_value = 100.1; id_3026_value = 513.9; id_3027_value = 13350;
        id_3028_value = 5.556; id_3029_value = 40.138; id_3030_value = 2.300; id_3031_value = 0.049; id_3032_value = 0.399;
        id_3101_value = 800; id_3102_value = 224; id_3103_value = 300; id_3104_value = 790; id_3105_value = 15; id_3106_value = 28; id_3107_value = 30;
        id_3108_value = 285.8; id_3109_value = 734; id_3110_value = 674; id_3112_value = 130; id_3113_value = 198; id_3114_value = 2.698;
        id_3115_value = 12.03; id_3116_value = 303400; id_3117_value = 7682; id_3118_value = 8699; id_3119_value = 32.58; id_3120_value = 138.8;
        id_3121_value = 12640; id_3122_value = 842.6; id_3123_value = 1312; id_3124_value = 6.65; id_3125_value = 106.1; id_3126_value = 596.9;
        id_3127_value = 18290; id_3128_value = 5.357; id_3129_value = 44.933; id_3130_value = 2.633; id_3131_value = 0.054; id_3132_value = 0.475;
        id_3201_value = 900; id_3202_value = 252; id_3203_value = 300; id_3204_value = 890; id_3205_value = 16; id_3206_value = 30; id_3207_value = 30;
        id_3208_value = 320.5; id_3209_value = 883030; id_3210_value = 770; id_3212_value = 132; id_3213_value = 198; id_3214_value = 2.8960;
        id_3215_value = 11.51; id_3216_value = 422100; id_3217_value = 9485; id_3218_value = 10810; id_3219_value = 36.29; id_3220_value = 163.3;
        id_3221_value = 13550; id_3222_value = 903.2; id_3223_value = 1414; id_3224_value = 6.5; id_3225_value = 111.1; id_3226_value = 736.8;
        id_3227_value = 24960; id_3228_value = 5.0; id_3229_value = 48.125; id_3230_value = 2.967; id_3231_value = 0.062; id_3232_value = 0.575;
        id_3301_value = 1000; id_3302_value = 272; id_3303_value = 300; id_3304_value = 990; id_3305_value = 16.5; id_3306_value = 31; id_3307_value = 30;
        id_3308_value = 346.8; id_3309_value = 928; id_3310_value = 868; id_3312_value = 132; id_3313_value = 198; id_3314_value = 3.0950;
        id_3315_value = 11.37; id_3316_value = 553800; id_3317_value = 11190; id_3318_value = 12820; id_3319_value = 39.96; id_3320_value = 184.6;
        id_3321_value = 14000; id_3322_value = 933.6; id_3323_value = 1470; id_3324_value = 6.35; id_3325_value = 113.6; id_3326_value = 822.4;
        id_3327_value = 32070; id_3328_value = 4.839; id_3329_value = 52.606; id_3330_value = 3.300; id_3331_value = 0.066; id_3332_value = 0.663;
    }

    private void setSecondTableValues() {
        id_1_value = 100;
        id_1001_value = 100; id_1002_value = 20.4; id_1003_value = 100; id_1004_value = 100; id_1005_value = 6; id_1006_value = 10; id_1007_value = 12;
        id_1008_value = 26; id_1009_value = 80; id_1010_value = 56; id_1012_value = 56; id_1013_value = 58; id_1014_value = 0.567; id_1015_value = 27.76;
        id_1016_value = 449.5; id_1017_value = 89.91;id_1018_value = 104.5; id_1019_value = 4.16; id_1020_value = 9.04; id_1021_value = 167.3; id_1022_value = 33.45;
        id_1023_value = 51.42; id_1024_value = 2.53;id_1025_value = 40.06; id_1026_value = 9.25; id_1027_value = 3.38; id_1028_value = 5.0; id_1029_value = 9.333;
        id_1030_value = 1.0; id_1031_value = 0.001; id_1032_value = 0.001;id_1101_value = 120; id_1102_value = 26.7; id_1103_value = 120; id_1104_value = 120;
        id_1105_value = 6.5; id_1106_value = 11; id_1107_value = 12; id_1108_value = 34;id_1109_value = 98; id_1110_value = 74; id_1112_value = 60; id_1113_value = 68;
        id_1114_value = 0.686; id_1115_value = 25.71; id_1116_value = 864.4; id_1117_value = 144.1; id_1118_value = 165.2; id_1119_value = 5.04; id_1120_value = 10.96;
        id_1121_value = 317.5; id_1122_value = 52.92; id_1123_value = 80.97; id_1124_value = 3.06; id_1125_value = 42.56; id_1126_value = 13.84; id_1127_value = 9.41;
        id_1128_value = 5.455; id_1129_value = 11.385; id_1130_value = 1.0; id_1131_value = 0.001; id_1132_value = 0.002;id_1201_value = 140; id_1202_value = 33.7;
        id_1203_value = 140; id_1204_value = 140; id_1205_value = 7; id_1206_value = 12; id_1207_value = 12;id_1208_value = 43; id_1209_value = 116; id_1210_value = 92;
        id_1212_value = 66; id_1213_value = 76; id_1214_value = 0.805; id_1215_value = 23.88; id_1216_value = 1509; id_1217_value = 215.6; id_1218_value = 245.4;
        id_1219_value = 5.93; id_1220_value = 13.08; id_1221_value = 549.7; id_1222_value = 78.52; id_1223_value = 119.8; id_1224_value = 3.58; id_1225_value = 45.06;
        id_1226_value = 20.06; id_1227_value = 22.48; id_1228_value = 5.833; id_1229_value = 13.143; id_1230_value = 1.0; id_1231_value = 0.002; id_1232_value = 0.003;
        id_1301_value = 160; id_1302_value = 42.6; id_1303_value = 160; id_1304_value = 160; id_1305_value = 8; id_1306_value = 13; id_1307_value = 15;
        id_1308_value = 54.3; id_1309_value = 134; id_1310_value = 104; id_1312_value = 80; id_1313_value = 84; id_1314_value = 0.918; id_1315_value = 21.56;
        id_1316_value = 2492; id_1317_value = 311.5; id_1318_value = 354; id_1319_value = 6.78; id_1320_value = 17.59; id_1321_value = 889.2; id_1322_value = 111.2;
        id_1323_value = 170; id_1324_value = 4.05; id_1325_value = 51.57; id_1326_value = 31.24; id_1327_value = 47.94; id_1328_value = 6.154; id_1329_value = 13.0;
        id_1330_value = 1.0; id_1331_value = 0.003; id_1332_value = 0.006; id_1401_value = 180; id_1402_value = 51.2; id_1403_value = 180; id_1404_value = 180;
        id_1405_value = 8.5; id_1406_value = 14; id_1407_value = 15; id_1408_value = 65.3; id_1409_value = 152; id_1410_value = 122; id_1412_value = 88;
        id_1413_value = 92; id_1414_value = 1.037; id_1415_value = 20.25; id_1416_value = 3831; id_1417_value = 425.7; id_1418_value = 481.4; id_1419_value = 7.66;
        id_1420_value = 20.24; id_1421_value = 1363; id_1422_value = 151.4; id_1423_value = 231; id_1424_value = 4.57; id_1425_value = 54.07; id_1426_value = 42.16;
        id_1427_value = 93.75; id_1428_value = 6.429; id_1429_value = 14.353; id_1430_value = 1.0; id_1431_value = 0.005; id_1432_value = 0.011;
        id_1501_value = 200; id_1502_value = 61.3; id_1503_value = 200; id_1504_value = 200; id_1505_value = 9; id_1506_value = 15; id_1507_value = 18;
        id_1508_value = 78.1; id_1509_value = 170; id_1510_value = 134; id_1512_value = 100; id_1513_value = 100; id_1514_value = 1.151; id_1515_value = 18.78;
        id_1516_value = 5696; id_1517_value = 569.6;id_1518_value = 342.5; id_1519_value = 8.54; id_1520_value = 24.83; id_1521_value = 2003; id_1522_value = 200.4;
        id_1523_value = 304.8; id_1524_value = 5.07;id_1525_value = 60.09; id_1526_value = 59.28; id_1527_value = 171.1; id_1528_value = 6.667; id_1529_value = 14.889;
        id_1530_value = 1.0; id_1531_value = 0.007; id_1532_value = 0.018;id_1601_value = 220; id_1602_value = 71.5; id_1603_value = 220; id_1604_value = 220;
        id_1605_value = 9.5; id_1606_value = 16; id_1607_value = 18; id_1608_value = 91; id_1609_value = 188; id_1610_value = 152; id_1612_value = 100;
        id_1613_value = 118; id_1614_value = 1.270; id_1615_value = 17.77; id_1616_value = 8091; id_1617_value = 735.5; id_1618_value = 827; id_1619_value = 9.43;
        id_1620_value = 27.92; id_1621_value = 2843; id_1622_value = 258.5; id_1623_value = 393.9; id_1624_value = 5.59; id_1625_value = 62.59; id_1626_value = 76.57;
        id_1627_value = 295.4; id_1628_value = 6.875; id_1629_value = 16.0; id_1630_value = 1.0; id_1631_value = 0.009; id_1632_value = 0.029;
        id_1701_value = 240; id_1702_value = 83.2; id_1703_value = 240; id_1704_value = 240; id_1705_value = 10; id_1706_value = 17; id_1707_value = 21;
        id_1708_value = 106; id_1709_value = 206; id_1710_value = 164; id_1712_value = 108; id_1713_value = 138; id_1714_value = 1.384;
        id_1715_value = 16.63; id_1716_value = 11260; id_1717_value = 938.3; id_1718_value = 1053; id_1719_value = 10.31; id_1720_value = 33.23; id_1721_value = 3923;
        id_1722_value = 326.9; id_1723_value = 498.4; id_1724_value = 6.308; id_1725_value = 68.6; id_1726_value = 102.7; id_1727_value = 486.9; id_1728_value = 7.059;
        id_1729_value = 16.400; id_1730_value = 1.000; id_1731_value = 0.012; id_1732_value = 0.043;
        id_1801_value = 260; id_1802_value = 93; id_1803_value = 260; id_1804_value = 260; id_1805_value = 10; id_1806_value = 17.5; id_1807_value = 24;
        id_1808_value = 118.4; id_1809_value = 225; id_1810_value = 177; id_1812_value = 114; id_1813_value = 158; id_1814_value = 1.499;
        id_1815_value = 16.12; id_1816_value = 14920; id_1817_value = 1148; id_1818_value = 1283; id_1819_value = 11.22; id_1820_value = 37.59;
        id_1821_value = 5135; id_1822_value = 395; id_1823_value = 602.2; id_1824_value = 6.58; id_1825_value = 73.12; id_1826_value = 123.8;
        id_1827_value = 753.7; id_1828_value = 7.429; id_1829_value = 17.700; id_1830_value = 1.0; id_1831_value = 0.016; id_1832_value = 0.061;
        id_1901_value = 280; id_1902_value = 103; id_1903_value = 280; id_1904_value = 280; id_1905_value = 10.5; id_1906_value = 18; id_1907_value = 24;
        id_1908_value = 131.4; id_1909_value = 244; id_1910_value = 196; id_1912_value = 114; id_1913_value = 178; id_1914_value = 1.618;
        id_1915_value = 15.69; id_1916_value = 19270; id_1917_value = 1376; id_1918_value = 1534; id_1919_value = 12.11; id_1920_value = 41.09;
        id_1921_value = 6595; id_1922_value = 471; id_1923_value = 717.6; id_1924_value = 7.09; id_1925_value = 74.62; id_1926_value = 143.7;
        id_1927_value = 1130; id_1928_value = 7.778; id_1929_value = 18.667; id_1930_value = 1.0; id_1931_value = 0.019; id_1932_value = 0.085;
        id_2001_value = 300; id_2002_value = 117; id_2003_value = 300; id_2004_value = 300; id_2005_value = 11; id_2006_value = 19; id_2007_value = 27;
        id_2008_value = 149.1; id_2009_value = 262; id_2010_value = 208; id_2012_value = 120; id_2013_value = 198; id_2014_value = 1.732;
        id_2015_value = 14.80; id_2016_value = 25170; id_2017_value = 1678; id_2018_value = 1869; id_2019_value = 12.99; id_2020_value = 47.43; id_2021_value = 8563;
        id_2022_value = 570.9; id_2023_value = 870.1; id_2024_value = 7.58; id_2025_value = 80.63; id_2026_value = 185; id_2027_value = 1688; id_2028_value = 7.895;
        id_2029_value = 18.909; id_2030_value = 1.0; id_2031_value = 0.025; id_2032_value = 0.119;
        id_2101_value = 32; id_2102_value = 127; id_2103_value = 300; id_2104_value = 320; id_2105_value = 11.5; id_2106_value = 20.5; id_2107_value = 27;
        id_2108_value = 161.3; id_2109_value = 279; id_2110_value = 225; id_2112_value = 122; id_2113_value = 198; id_2114_value = 1.771;
        id_2115_value = 13.98; id_2116_value = 30820; id_2117_value = 1926; id_2118_value = 2149; id_2119_value = 13.82; id_2120_value = 51.77;
        id_2121_value = 9239; id_2122_value = 615.9; id_2123_value = 939.1; id_2124_value = 7.57; id_2125_value = 84.13; id_2126_value = 225.1; id_2127_value = 2069;
        id_2128_value = 7.317; id_2129_value = 19.565; id_2130_value = 1.067; id_2131_value = 0.028; id_2132_value = 0.137;
        id_2201_value = 340; id_2202_value = 134; id_2203_value = 300; id_2204_value = 340; id_2205_value = 12; id_2206_value = 21.5; id_2207_value = 27;
        id_2208_value = 170.9; id_2209_value = 297; id_2210_value = 243; id_2212_value = 122; id_2213_value = 198; id_2214_value = 1.81;
        id_2215_value = 13.49; id_2216_value = 36660; id_2217_value = 2156; id_2218_value = 2408; id_2219_value = 14.65; id_2220_value = 56.09;
        id_2221_value = 9690; id_2222_value = 646; id_2223_value = 985.7; id_2224_value = 7.53; id_2225_value = 86.63; id_2226_value = 257.2; id_2227_value = 2454;
        id_2228_value = 6.977; id_2229_value = 20.250; id_2230_value = 1.133; id_2231_value = 0.031; id_2232_value = 0.152;
        id_2301_value = 360; id_2302_value = 142; id_2303_value = 300; id_2304_value = 360; id_2305_value = 12.5; id_2306_value = 22.5; id_2307_value = 27;
        id_2308_value = 180.6; id_2309_value = 315; id_2310_value = 261; id_2312_value = 122; id_2313_value = 198; id_2314_value = 1.849;
        id_2315_value = 13.04; id_2316_value = 43190; id_2317_value = 2400; id_2318_value = 2683; id_2319_value = 15.46; id_2320_value = 60.6;
        id_2321_value = 10140; id_2322_value = 676.1; id_2323_value = 1032; id_2324_value = 7.49; id_2325_value = 89.13; id_2326_value = 292.5; id_2327_value = 2883;
        id_2328_value = 6.667; id_2329_value = 20.880; id_2330_value = 1.200; id_2331_value = 0.034; id_2332_value = 0.169;
        id_2401_value = 400; id_2402_value = 155; id_2403_value = 300; id_2404_value = 400; id_2405_value = 13.5; id_2406_value = 24; id_2407_value = 27;
        id_2408_value = 197.8; id_2409_value = 352; id_2410_value = 298; id_2412_value = 124; id_2413_value = 198; id_2414_value = 1.927;
        id_2415_value = 12.41; id_2416_value = 57680; id_2417_value = 2884; id_2418_value = 3232; id_2419_value = 17.08; id_2420_value = 69.98;
        id_2421_value = 10820; id_2422_value = 721.3; id_2423_value = 1104; id_2424_value = 7.4; id_2425_value = 93.13; id_2426_value = 355.7; id_2427_value = 3817;
        id_2428_value = 6.250; id_2429_value = 22.074; id_2430_value = 1.333; id_2431_value = 0.038; id_2432_value = 0.201;
        id_2501_value = 450; id_2502_value = 171; id_2503_value = 300; id_2504_value = 450; id_2505_value = 14; id_2506_value = 26; id_2507_value = 27;
        id_2508_value = 218; id_2509_value = 398; id_2510_value = 344; id_2512_value = 124; id_2513_value = 198; id_2514_value = 2.026;
        id_2515_value = 11.84; id_2516_value = 79890; id_2517_value = 3551; id_2518_value = 3982; id_2519_value = 19.14; id_2520_value = 79.66;
        id_2521_value = 11720; id_2522_value = 781.4; id_2523_value = 1198; id_2524_value = 7.33; id_2525_value = 97.63; id_2526_value = 440.5;
        id_2527_value = 5258; id_2528_value = 5.769; id_2529_value = 24.571; id_2530_value = 1.5; id_2531_value = 0.044; id_2532_value = 0.245;
        id_2601_value = 500; id_2602_value = 187; id_2603_value = 300; id_2604_value = 500; id_2605_value = 14.5; id_2606_value = 28; id_2607_value = 27;
        id_2608_value = 238.6; id_2609_value = 444; id_2610_value = 390; id_2612_value = 124; id_2613_value = 198; id_2614_value = 2.125;
        id_2615_value = 11.34; id_2616_value = 107200; id_2617_value = 4287; id_2618_value = 4815; id_2619_value = 21.19; id_2620_value = 89.82;
        id_2621_value = 12620; id_2622_value = 8431.6; id_2623_value = 1292; id_2624_value = 7.27; id_2625_value = 102.1; id_2626_value = 538.4; id_2627_value = 7018;
        id_2628_value = 5.357; id_2629_value = 26.897; id_2630_value = 1.667; id_2631_value = 0.051; id_2632_value = 0.294;
        id_2701_value = 550; id_2702_value = 199; id_2703_value = 300; id_2704_value = 550; id_2705_value = 15; id_2706_value = 29; id_2707_value = 27;
        id_2708_value = 254.1; id_2709_value = 492; id_2710_value = 438; id_2712_value = 124; id_2713_value = 198; id_2714_value = 2.224;
        id_2715_value = 11.15; id_2716_value = 136700; id_2717_value = 4971; id_2718_value = 5591; id_2719_value = 23.2; id_2720_value = 100.1;
        id_2721_value = 13080; id_2722_value = 871.8; id_2723_value = 1341; id_2724_value = 7.17; id_2725_value = 104.6; id_2726_value = 600.3;
        id_2727_value = 8856; id_2728_value = 5.172; id_2729_value = 29.200; id_2730_value = 1.833; id_2731_value = 0.055; id_2732_value = 0.336;
        id_2801_value = 600; id_2802_value = 212; id_2803_value = 300; id_2804_value = 600; id_2805_value = 15.5; id_2806_value = 30; id_2807_value = 27;
        id_2808_value = 270; id_2809_value = 540; id_2810_value = 486; id_2812_value = 126; id_2813_value = 198; id_2814_value = 2.323;
        id_2815_value = 10.96; id_2816_value = 171000; id_2817_value = 5701; id_2818_value = 6425; id_2819_value = 25.17; id_2820_value = 110.8;
        id_2821_value = 13530; id_2822_value = 902; id_2823_value = 1391; id_2824_value = 7.08; id_2825_value = 107.1; id_2826_value = 667.25;
        id_2827_value = 10970; id_2828_value = 5.0; id_2829_value = 31.355; id_2830_value = 2.0; id_2831_value = 0.059; id_2832_value = 0.381;
        id_2901_value = 650; id_2902_value = 225; id_2903_value = 300; id_2904_value = 650; id_2905_value = 16; id_2906_value = 31; id_2907_value = 27;
        id_2908_value = 286.3; id_2909_value = 588; id_2910_value = 534; id_2912_value = 126; id_2913_value = 198; id_2914_value = 2.422;
        id_2915_value = 10.77; id_2916_value = 210600; id_2917_value = 6480; id_2918_value = 7320; id_2919_value = 27.12; id_2920_value = 122;
        id_2921_value = 13980; id_2922_value = 932.3; id_2923_value = 1441; id_2924_value = 6.99; id_2925_value = 109.6; id_2926_value = 739.2;
        id_2927_value = 13360; id_2928_value = 4.839; id_2929_value = 33.375; id_2930_value = 2.167; id_2931_value = 0.063; id_2932_value = 0.427;
        id_3001_value = 700; id_3002_value = 241; id_3003_value = 300; id_3004_value = 700; id_3005_value = 17; id_3006_value = 32;
        id_3007_value = 27; id_3008_value = 306.4; id_3009_value = 636; id_3010_value = 582; id_3012_value = 126; id_3013_value = 198;
        id_3014_value = 2.520; id_3015_value = 10.48; id_3016_value = 256900; id_3017_value = 7340; id_3018_value = 8327; id_3019_value = 28.96;
        id_3020_value = 137.1; id_3021_value = 14440; id_3022_value = 962.6; id_3023_value = 1495; id_3024_value = 6.87; id_3025_value = 112.6;
        id_3026_value = 830.9; id_3027_value = 16060; id_3028_value = 4.688; id_3029_value = 34.235; id_3030_value = 2.333; id_3031_value = 0.067; id_3032_value = 0.476;
        id_3101_value = 800; id_3102_value = 262; id_3103_value = 300; id_3104_value = 800; id_3105_value = 17.5; id_3106_value = 33;
        id_3107_value = 30; id_3108_value = 334.2; id_3109_value = 734; id_3110_value = 674; id_3112_value = 134; id_3113_value = 198;
        id_3114_value = 2.713; id_3115_value = 10.34; id_3116_value = 359100; id_3117_value = 8977; id_3118_value = 10230; id_3119_value = 32.78;
        id_3120_value = 161.8; id_3121_value = 14900; id_3122_value = 993.6; id_3123_value = 1553; id_3124_value = 6.68; id_3125_value = 118.6;
        id_3126_value = 946; id_3127_value = 21840; id_3128_value = 4.545; id_3129_value = 38.514; id_3130_value = 2.667; id_3131_value = 0.073; id_3132_value = 0.564;
        id_3201_value = 900; id_3202_value = 291; id_3203_value = 300; id_3204_value = 900; id_3205_value = 18.5; id_3206_value = 35;
        id_3207_value = 30; id_3208_value = 371.3; id_3209_value = 830; id_3210_value = 770; id_3212_value = 134; id_3213_value = 198;
        id_3214_value = 2.911; id_3215_value = 9.99; id_3216_value = 494100; id_3217_value = 10980; id_3218_value = 12580; id_3219_value = 36.48;
        id_3220_value = 188.8; id_3221_value = 15820; id_3222_value = 1050; id_3223_value = 1658; id_3224_value = 6.53; id_3225_value = 123.6;
        id_3226_value = 1137; id_3227_value = 29460; id_3228_value = 4.286; id_3229_value = 41.622; id_3230_value = 3.0; id_3231_value = 0.083; id_3232_value = 0.675;
        id_3301_value = 1000; id_3302_value = 314; id_3303_value = 300; id_3304_value = 1000; id_3305_value = 19; id_3306_value = 36;
        id_3307_value = 30; id_3308_value = 400; id_3309_value = 928; id_3310_value = 868; id_3312_value = 134; id_3313_value = 198;
        id_3314_value = 3.110; id_3315_value = 9.905; id_3316_value = 644700; id_3317_value = 12890; id_3318_value = 14860; id_3319_value = 40.15;
        id_3320_value = 212.5; id_3321_value = 16280; id_3322_value = 1085; id_3323_value = 1716; id_3324_value = 6.38; id_3325_value = 126.1;
        id_3326_value = 1254; id_3327_value = 37640; id_3328_value = 4.167; id_3329_value = 45.684; id_3330_value = 3.333; id_3331_value = 0.088; id_3332_value = 0.774;
    }

    private void setFirstTableValues() {
        id_1_value = 80;
        id_1001_value = 80; id_1002_value = 5.94; id_1003_value = 42; id_1004_value = 80; id_1005_value = 3.9; id_1006_value = 5.9; id_1007_value = 3.9;
        id_1008_value = 2.3; id_1009_value = 7.57; id_1010_value = 59; id_1014_value = 0.3; id_1015_value = 51.09; id_1016_value = 77.8; id_1017_value = 19.5;
        id_1018_value = 22.8; id_1019_value = 3.2; id_1020_value = 3.41; id_1021_value = 6.29; id_1022_value = 3; id_1023_value = 5; id_1024_value = 0.91;
        id_1025_value = 21.6; id_1026_value = 0.87; id_1027_value = 0.09; id_1028_value = 3.559; id_1029_value = 15.487; id_1030_value = 1.905; id_1031_value = 1;id_1032_value = 1;
        id_1101_value = 100; id_1102_value = 8.34; id_1103_value = 50; id_1104_value = 100; id_1105_value = 4.5; id_1106_value = 6.8; id_1107_value = 4.5; id_1108_value = 2.7;
        id_1109_value = 10.6; id_1110_value = 75.7; id_1114_value = 0.37; id_1115_value = 44.47; id_1116_value = 171.0; id_1117_value = 34.2; id_1118_value = 39.8;
        id_1119_value = 4.01; id_1120_value = 4.85; id_1121_value = 12.2; id_1122_value = 4.88; id_1123_value = 8.1; id_1124_value = 1.07; id_1125_value = 25.0;
        id_1126_value = 1.6; id_1127_value = 0.27; id_1128_value = 3.676; id_1129_value = 17.2; id_1130_value = 2.0; id_1131_value = 1; id_1132_value = 1;
        id_1201_value = 120; id_1202_value = 11.1; id_1203_value = 58; id_1204_value = 120; id_1205_value = 5.1; id_1206_value = 7.7; id_1207_value = 5.1;
        id_1208_value = 3.1; id_1209_value = 14.2; id_1210_value = 92.4; id_1214_value = 0.44; id_1215_value = 39.38; id_1216_value = 328.0; id_1217_value = 54.70;
        id_1218_value = 63.60; id_1219_value = 4.81; id_1220_value = 6.63; id_1221_value = 21.40; id_1222_value = 7.41; id_1223_value = 12.40; id_1224_value = 1.23;
        id_1225_value = 28.40; id_1226_value = 2.71; id_1227_value = 0.69; id_1228_value = 3.766; id_1229_value = 18.510; id_1230_value = 2.069; id_1231_value = 1; id_1232_value = 1;
        id_1301_value = 140; id_1302_value = 14.3; id_1303_value = 66; id_1304_value = 140; id_1305_value = 5.7; id_1306_value = 8.6; id_1307_value = 5.7;
        id_1308_value = 3.4; id_1309_value = 18.2; id_1310_value = 109.1; id_1314_value = 0.50; id_1315_value = 34.94; id_1316_value = 573.00; id_1317_value = 81.90;
        id_1318_value = 95.40; id_1319_value = 5.61; id_1320_value = 8.65; id_1321_value = 35.20; id_1322_value = 10.70; id_1323_value = 17.90; id_1324_value = 1.40;
        id_1325_value = 31.80; id_1326_value = 4.32; id_1327_value = 1.54; id_1328_value = 3.837; id_1329_value = 19.544; id_1330_value = 2.121; id_1331_value = 1; id_1332_value = 1;
        id_1401_value = 160; id_1402_value = 17.9; id_1403_value = 74; id_1404_value = 160; id_1405_value = 6.3; id_1406_value = 9.5; id_1407_value = 6.3;
        id_1408_value = 3.8; id_1409_value = 22.8; id_1410_value = 125.8; id_1414_value = 0.58; id_1415_value = 32.13; id_1416_value = 935.00; id_1417_value = 117.00;
        id_1418_value = 136.00; id_1419_value = 6.40; id_1420_value = 10.83; id_1421_value = 54.70; id_1422_value = 14.80; id_1423_value = 24.90;
        id_1424_value = 1.55; id_1425_value = 35.20; id_1426_value = 6.57; id_1427_value = 3.14; id_1428_value = 3.895; id_1429_value = 20.381; id_1430_value = 2.162; id_1431_value = 1; id_1432_value = 1;
        id_1501_value = 180; id_1502_value = 21.9; id_1503_value = 82; id_1504_value = 180; id_1505_value = 6.9; id_1506_value = 10.4; id_1507_value = 6.9;
        id_1508_value = 4.1; id_1509_value = 27.9; id_1510_value = 142.4; id_1514_value = 0.64; id_1515_value = 29.22; id_1516_value = 1450.00; id_1517_value = 161.00;
        id_1518_value = 187.0; id_1519_value = 7.2; id_1520_value = 13.35; id_1521_value = 81.30; id_1522_value = 19.80; id_1523_value = 33.20; id_1524_value = 1.71;
        id_1525_value = 38.60; id_1526_value = 9.58; id_1527_value = 5.92; id_1528_value = 3.942; id_1529_value = 21.072; id_1530_value = 2.195; id_1531_value = 1; id_1532_value = 1;
        id_1601_value = 200; id_1602_value = 26.2; id_1603_value = 90; id_1604_value = 200; id_1605_value = 7.5; id_1606_value = 11.3; id_1607_value = 7.5;
        id_1608_value = 4.5; id_1609_value = 33.4; id_1610_value = 159.1; id_1614_value = 0.71; id_1615_value = 27.04; id_1616_value = 2140.0; id_1617_value = 214.00;
        id_1618_value = 250.00; id_1619_value = 8.00; id_1620_value = 16.03; id_1621_value = 117.0; id_1622_value = 26.00; id_1623_value = 43.50; id_1624_value = 187.00;
        id_1625_value = 42.00; id_1626_value = 13.50; id_1627_value = 10.50; id_1628_value = 3.982; id_1629_value = 21.653; id_1630_value = 2.222; id_1631_value = 1; id_1632_value = 1;
        id_1701_value = 220; id_1702_value = 31.1; id_1703_value = 98; id_1704_value = 220; id_1705_value = 8.1; id_1706_value = 12.2; id_1707_value = 8.1;
        id_1708_value = 4.9; id_1709_value = 39.5; id_1710_value = 175.8; id_1711_value = 10; id_1712_value = 50; id_1713_value = 56; id_1714_value = 0.78;
        id_1715_value = 24.99; id_1716_value = 3060.0; id_1717_value = 278.0; id_1718_value = 324.0; id_1719_value = 8.8; id_1720_value = 19.06; id_1721_value = 162.00;
        id_1722_value = 33.10; id_1723_value = 55.70; id_1724_value = 2.02; id_1725_value = 45.40; id_1726_value = 18.60; id_1727_value = 17.80; id_1728_value = 4.016;
        id_1729_value = 22.148; id_1730_value = 2.245; id_1731_value = 1; id_1732_value = 1;
        id_1801_value = 240; id_1802_value = 36.2; id_1803_value = 106; id_1804_value = 240; id_1805_value = 8.7; id_1806_value = 13.1; id_1807_value = 8.7;
        id_1808_value = 5.2; id_1809_value = 46.1; id_1810_value = 192.5; id_1811_value = 10; id_1812_value = 54; id_1813_value = 60; id_1814_value = 0.84;
        id_1815_value = 23.32; id_1816_value = 4250.00; id_1817_value = 354.00; id_1818_value = 412.00; id_1819_value = 9.59; id_1820_value = 22.33;
        id_1821_value = 221.00; id_1822_value = 41.70; id_1823_value = 70.00; id_1824_value = 2.20; id_1825_value = 48.90; id_1826_value = 25.00;
        id_1827_value = 28.70; id_1828_value = 4.046; id_1829_value = 22.575; id_1830_value = 2.264; id_1831_value = 1; id_1832_value = 1;
        id_1901_value = 260; id_1902_value = 41.9; id_1903_value = 113; id_1904_value = 260; id_1905_value = 9.4; id_1906_value = 14.1; id_1907_value = 9.4;
        id_1908_value = 5.6; id_1909_value = 53.3; id_1910_value = 208.9; id_1911_value = 12; id_1912_value = 62; id_1913_value = 62; id_1914_value = 0.91;
        id_1915_value = 21.65; id_1916_value = 5740.00; id_1917_value = 442.00; id_1918_value = 514.0; id_1919_value = 10.4; id_1920_value = 26.08;
        id_1921_value = 288.0; id_1922_value = 51.00; id_1923_value = 85.90; id_1924_value = 2.32; id_1925_value = 52.60; id_1926_value = 33.50;
        id_1927_value = 44.10; id_1928_value = 4.007; id_1929_value = 22.660; id_1930_value = 2.301; id_1931_value = 1; id_1932_value = 1;
        id_2001_value = 280; id_2002_value = 47.9; id_2003_value = 119; id_2004_value = 280; id_2005_value = 10.1; id_2006_value = 15.2; id_2007_value = 10.1;
        id_2008_value = 6.1; id_2009_value = 61; id_2010_value = 225.1; id_2011_value = 12; id_2012_value = 68; id_2013_value = 68; id_2014_value = 0.97;
        id_2015_value = 20.17; id_2016_value = 7590.0; id_2017_value = 542.0; id_2018_value = 632.0; id_2019_value = 11.1; id_2020_value = 30.18; id_2021_value = 364.0;
        id_2022_value = 61.2; id_2023_value = 103.0; id_2024_value = 2.45; id_2025_value = 56.4; id_2026_value = 44.2; id_2027_value = 64.6; id_2028_value = 3.914;
        id_2029_value = 22.713; id_2030_value = 2.353; id_2031_value = 1; id_2032_value = 1;
        id_2101_value = 300; id_2102_value = 54.2; id_2103_value = 125; id_2104_value = 300; id_2105_value = 10.8; id_2106_value = 16.2; id_2107_value = 10.8;
        id_2108_value = 6.5; id_2109_value = 69; id_2110_value = 241.6; id_2111_value = 12; id_2112_value = 70; id_2113_value = 74; id_2114_value = 1.03;
        id_2115_value = 19.02; id_2116_value = 9800.0; id_2117_value = 653.0; id_2118_value = 762.0; id_2119_value = 11.9; id_2120_value = 34.58;
        id_2121_value = 451.0; id_2122_value = 72.2; id_2123_value = 121.0; id_2124_value = 2.56; id_2125_value = 60.1; id_2126_value = 56.8; id_2127_value = 91.8;
        id_2128_value = 3.858; id_2129_value = 22.778; id_2130_value = 2.4; id_2131_value = 1; id_2132_value = 1;
        id_2201_value = 320; id_2202_value = 61; id_2203_value = 131; id_2204_value = 320; id_2205_value = 11.5; id_2206_value = 17.3; id_2207_value = 11.5;
        id_2208_value = 6.9; id_2209_value = 77.7; id_2210_value = 257.9; id_2211_value = 12; id_2212_value = 70; id_2213_value = 80; id_2214_value = 1.09;
        id_2215_value = 17.87; id_2216_value = 12510.0; id_2217_value = 782.0; id_2218_value = 914.0; id_2219_value = 12.7; id_2220_value = 39.26;
        id_2221_value = 555.0; id_2222_value = 84.7; id_2223_value = 143.0; id_2224_value = 2.67; id_2225_value = 63.9; id_2226_value = 72.5; id_2227_value = 129.0;
        id_2228_value = 3.786; id_2229_value = 22.817; id_2230_value = 2.443; id_2231_value = 1; id_2232_value = 1;
        id_2301_value = 340; id_2302_value = 68; id_2303_value = 137; id_2304_value = 340; id_2305_value = 12.2; id_2306_value = 18.3; id_2307_value = 12.2;
        id_2308_value = 7.3; id_2309_value = 86.7; id_2310_value = 274.3; id_2311_value = 12; id_2312_value = 78; id_2313_value = 86; id_2314_value = 1.15;
        id_2315_value = 16.9; id_2316_value = 15700.0; id_2317_value = 923.0; id_2318_value = 1080.0; id_2319_value = 13.5; id_2320_value = 44.27;
        id_2321_value = 674.0; id_2322_value = 98.4; id_2323_value = 166.0; id_2324_value = 2.8; id_2325_value = 67.6; id_2326_value = 90.4; id_2327_value = 176.0;
        id_2328_value = 3.743; id_2329_value = 22.869; id_2330_value = 2.482; id_2331_value = 1; id_2332_value = 1;
        id_2401_value = 360; id_2402_value = 76.1; id_2403_value = 143; id_2404_value = 360; id_2405_value = 13; id_2406_value = 19.5; id_2407_value = 13;
        id_2408_value = 7.8; id_2409_value = 97; id_2410_value = 290; id_2411_value = 12; id_2412_value = 78; id_2413_value = 92; id_2414_value = 1.21;
        id_2415_value = 15.89; id_2416_value = 19610.0; id_2417_value = 1090.0; id_2418_value = 1276.0; id_2419_value = 14.2; id_2420_value = 49.95;
        id_2421_value = 818.0; id_2422_value = 114.0; id_2423_value = 194.0; id_2424_value = 2.9; id_2425_value = 71.8; id_2426_value = 115.0; id_2427_value = 240.0;
        id_2428_value = 3.667; id_2429_value = 22.692; id_2430_value = 2.517; id_2431_value = 1; id_2432_value = 1;
        id_2501_value = 380; id_2502_value = 84; id_2503_value = 149; id_2504_value = 380; id_2505_value = 13.7; id_2506_value = 20.5; id_2507_value = 13.7;
        id_2508_value = 8.2; id_2509_value = 107; id_2510_value = 306.7; id_2511_value = 16; id_2512_value = 84; id_2513_value = 86; id_2514_value = 1.27;
        id_2515_value = 15.12; id_2516_value = 24010.0; id_2517_value = 1260.0; id_2518_value = 1482.0; id_2519_value = 15.0; id_2520_value = 55.55;
        id_2521_value = 975.0; id_2522_value = 131.0; id_2523_value = 221.0; id_2524_value = 3.02; id_2525_value = 75.4; id_2526_value = 141.0;
        id_2527_value = 319.0; id_2528_value = 3.634; id_2529_value = 22.745; id_2530_value = 2.55; id_2531_value = 1; id_2532_value = 1;
        id_2601_value = 400; id_2602_value = 92.4; id_2603_value = 155; id_2604_value = 400; id_2605_value = 14.4; id_2606_value = 21.6; id_2607_value = 14.4;
        id_2608_value = 8.6; id_2609_value = 118; id_2610_value = 322.9; id_2611_value = 16; id_2612_value = 86; id_2613_value = 92; id_2614_value = 1.33;
        id_2615_value = 14.36; id_2616_value = 29210.0; id_2617_value = 1460.0; id_2618_value = 1714.0; id_2619_value = 15.7; id_2620_value = 61.69;
        id_2621_value = 1160.0; id_2622_value = 149.0; id_2623_value = 253.0; id_2624_value = 3.13; id_2625_value = 79.3; id_2626_value = 170.0; id_2627_value = 420.0;
        id_2628_value = 3.588; id_2629_value = 22.778; id_2630_value = 2.581; id_2631_value = 1; id_2632_value = 1;
        id_2701_value = 450; id_2702_value = 115; id_2703_value = 170; id_2704_value = 450; id_2705_value = 16.2; id_2706_value = 24.3; id_2707_value = 16.2;
        id_2708_value = 9.7; id_2709_value = 147; id_2710_value = 363.6; id_2711_value = 16; id_2712_value = 92; id_2713_value = 106; id_2714_value = 1.48;
        id_2715_value = 12.83; id_2716_value = 45850.0; id_2717_value = 2040.0; id_2718_value = 2400.0; id_2719_value = 17.7; id_2720_value = 77.79;
        id_2721_value = 1730.0; id_2722_value = 203.0; id_2723_value = 345.0; id_2724_value = 3.43; id_2725_value = 88.9; id_2726_value = 267.0;
        id_2727_value = 791.0; id_2728_value = 3.498; id_2729_value = 22.778; id_2730_value = 2.647; id_2731_value = 1; id_2732_value = 1;
        id_2801_value = 500; id_2802_value = 141; id_2803_value = 185; id_2804_value = 500; id_2805_value = 18; id_2806_value = 27; id_2807_value = 18;
        id_2808_value = 10.8; id_2809_value = 179; id_2810_value = 404.3; id_2811_value = 20; id_2812_value = 102; id_2813_value = 110; id_2814_value = 1.63;
        id_2815_value = 11.6; id_2816_value = 68740.0; id_2817_value = 2750.0; id_2818_value = 3240.0; id_2819_value = 19.6; id_2820_value = 95.6;
        id_2821_value = 2480.0; id_2822_value = 268.0; id_2823_value = 456.0; id_2824_value = 3.72; id_2825_value = 98.5; id_2826_value = 402.0;
        id_2827_value = 1400.0; id_2828_value = 3.426; id_2829_value = 22.778; id_2830_value = 2.703; id_2831_value = 1; id_2832_value = 1;
        id_2901_value = 550; id_2902_value = 166; id_2903_value = 200; id_2904_value = 550; id_2905_value = 19; id_2906_value = 30; id_2907_value = 19;
        id_2908_value = 11.9; id_2909_value = 212; id_2910_value = 445.6; id_2911_value = 22; id_2912_value = 112; id_2913_value = 118; id_2914_value = 1.80;
        id_2915_value = 10.8; id_2916_value = 99180.0; id_2917_value = 3610.0; id_2918_value = 4240.0; id_2919_value = 21.6; id_2920_value = 111.3;
        id_2921_value = 3490.0; id_2922_value = 349.0; id_2923_value = 592.0; id_2924_value = 4.02; id_2925_value = 107.3; id_2926_value = 544.0;
        id_2927_value = 2390.0; id_2928_value = 3.333; id_2929_value = 23.789; id_2930_value = 2.75; id_2931_value = 1; id_2932_value = 1;
        id_3001_value = 600; id_3002_value = 199; id_3003_value = 215; id_3004_value = 600; id_3005_value = 21.6; id_3006_value = 32.4;
        id_3007_value = 21.6; id_3008_value = 13; id_3009_value = 254; id_3010_value = 485.8; id_3011_value = 24; id_3012_value = 126; id_3013_value = 128;
        id_3014_value = 192.0; id_3015_value = 9.89; id_3016_value = 139000.0; id_3017_value = 4630.0; id_3018_value = 5452.0; id_3019_value = 23.4;
        id_3020_value = 138.0; id_3021_value = 4670.0; id_3022_value = 434.0; id_3023_value = 752.0; id_3024_value = 4.3; id_3025_value = 117.6;
        id_3026_value = 787.0; id_3027_value = 3814.0; id_3028_value = 3.318; id_3029_value = 22.778; id_3030_value = 2.791; id_3031_value = 1; id_3032_value = 1;
    }

    private void insertToDB() {
        Log.d("checkInsertUpdate", "insertToDB() -> currentUserEmailGlobal == " + currentUserEmailGlobal);
        sqLiteDatabase.execSQL(sqlHelper.insertSteelCeiling_SQL(DialogHelper.input, moduleActiveId, categoryActiveId, subCategoryActiveId,
                id_1_value, id_14_value, id_15_value, id_17_value, id_21_value, id_22_value, id_23_value, id_27_value, id_43_value,
                id_44_value, id_55_value, id_56_value, id_66_value, id_71_value, id_72_value, id_47_position, id_59_position));
        new SQLRemote(QUERY_TYPE_INSERT_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", DialogHelper.input);
    }


    private void updateDB() {
        sqLiteDatabase.execSQL(sqlHelper.updateSteelCeiling_SQL(savedVersionTitle, moduleActiveId, categoryActiveId, subCategoryActiveId,
                id_1_value, id_14_value, id_15_value, id_17_value, id_21_value, id_22_value, id_23_value, id_27_value, id_43_value,
                id_44_value, id_55_value, id_56_value, id_66_value, id_71_value, id_72_value, id_47_position, id_59_position));
        new SQLRemote(QUERY_TYPE_UPDATE_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", savedVersionTitle);
    }

    private void resetValues() {
        id_14_value = 195; id_15_value = 1000; id_17_value = 1; id_21_value = 0.001; id_22_value = 0.001; id_23_value = 0.001; id_27_value = 1;
        id_43_value = 1; id_44_value = 1; id_55_value = 1; id_56_value = 1; id_66_value = 1; id_71_value = 1; id_72_value = 1;
        id_1_position = 0; id_14_position = 0; id_47_position = 0; id_59_position = 0;
    }

//    private void resetValues() {
//        id_14_value = 215; id_15_value = 205000; id_17_value = 1.08; id_21_value = 0.001; id_22_value = 0.002; id_23_value = 0.003; id_27_value = 7;
//        id_43_value = 8; id_44_value = 9; id_55_value = 10; id_56_value = 11; id_66_value = 12; id_71_value = 13; id_72_value = 14;
//        id_1_position = 0; id_14_position = 2; id_47_position = 1; id_59_position = 1;
//    }

    public ArrayList<StructuralDesignModel> initModels(boolean isForSetValuesModels) {
        resultPositionsByIds = new ArrayMap<>();
        valuesPositionsByIds = new ArrayMap<>();
        if (isForSetValuesModels){
            valuesModels = new ArrayList<>();
            // 0
            valuesModels.add(new StructuralDesignModel(1, "תכונת החתך", "","", "",id_1_position));
            // 1
            valuesModels.add(new StructuralDesignModel(0, secondaryTitles.get(1), "","", "",0));
            valuesModels.add(new StructuralDesignModel(14, "סוג הפלדה", "","", "",id_14_position));
            valuesModels.add(new StructuralDesignModel(15, "סוג הפלדה", "Es","[Mpa]", id_15_value+"",0));
            valuesModels.add(new StructuralDesignModel(17, "סוג הפלדה", "ɣs","[Mpa]", id_17_value+"",0));
            // 5
            valuesModels.add(new StructuralDesignModel(0, "", "","", "",0));
            valuesModels.add(new StructuralDesignModel(21, "Axial force", "","[MN]", id_21_value+"",0));
            valuesModels.add(new StructuralDesignModel(22, "Bending moment", "","[MN*m]", id_22_value+"",0));
            valuesModels.add(new StructuralDesignModel(23, "Shear force", "","[MN]", id_23_value+"",0));
            valuesModels.add(new StructuralDesignModel(27, "פסיעה בין קשתות", "","", id_27_value+"",0));
            // 10
            valuesModels.add(new StructuralDesignModel(0, secondaryTitles.get(6), "","", "",0));
            valuesModels.add(new StructuralDesignModel(43, "ג'וליאן לורנס", "K","", id_43_value+"",0));
            valuesModels.add(new StructuralDesignModel(44, "אורך רכיב", "l","[cm]", id_44_value+"",0));
            valuesModels.add(new StructuralDesignModel(47, "עקום קריסה-טבלה 18", "","", "",id_47_position));
            // 14
            valuesModels.add(new StructuralDesignModel(0, secondaryTitles.get(7), "","", "",0));
            valuesModels.add(new StructuralDesignModel(55, "ג'וליאן לורנס", "K","", id_55_value+"",0));
            valuesModels.add(new StructuralDesignModel(56, "אורך רכיב", "l","[cm]", id_56_value+"",0));
            valuesModels.add(new StructuralDesignModel(59, "עקום קריסה-טבלה 18", "","", "",id_59_position));
            // 18
            valuesModels.add(new StructuralDesignModel(0, secondaryTitles.get(8), "","", "",0));
            valuesModels.add(new StructuralDesignModel(66, "אורך פעיל לקריסה צידית", "le","[m]", id_66_value+"",0));
            valuesModels.add(new StructuralDesignModel(71, "פרופיל מעורגל", "","n", id_71_value+"",0));
            valuesModels.add(new StructuralDesignModel(72, "תלוי מהלך מומנטים", "","m", id_72_value+"",0));
            setValuesModelsPositions();
            return valuesModels;
        } else {
            resultModels = new ArrayList<>();
            // 0
            resultModels.add(new StructuralDesignModel(2, "תכונת החתך", "D","[mm]", mathId_2(),0));
            resultModels.add(new StructuralDesignModel(3, "תכונת החתך", "B","[mm]", mathId_3(),0));
            resultModels.add(new StructuralDesignModel(4, "תכונת החתך", "tw","[mm]", mathId_4(),0));
            resultModels.add(new StructuralDesignModel(5, "תכונת החתך", "tw","[mm]", mathId_5(),0));
            resultModels.add(new StructuralDesignModel(6, "תכונת החתך", "R2","[mm]", mathId_6(),0));
            resultModels.add(new StructuralDesignModel(7, "תכונת החתך", "A","[cm^2]", mathId_7(),0));
            resultModels.add(new StructuralDesignModel(8, "תכונת החתך", "Ixx","[cm^4]", mathId_8(),0));
            resultModels.add(new StructuralDesignModel(9, "תכונת החתך", "lyy","[cm^4]", mathId_9(),0));
            resultModels.add(new StructuralDesignModel(10, "תכונת החתך", "ix","[cm]", mathId_10(),0));
            resultModels.add(new StructuralDesignModel(11, "תכונת החתך", "iy","[cm]", mathId_11(),0));
            resultModels.add(new StructuralDesignModel(12, "תכונת החתך", "Wel","[cm^3]", mathId_12(),0));
            resultModels.add(new StructuralDesignModel(13, "תכונת החתך", "Wpl","[cm^3]", mathId_13(),0));
            // 12
            resultModels.add(new StructuralDesignModel(0, secondaryTitles.get(1), "","", "",0));
            resultModels.add(new StructuralDesignModel(16, "סוג הפלדה", "fy","[Mpa]", mathId_16(),0));
            resultModels.add(new StructuralDesignModel(18, "סוג הפלדה", "fs","[Mpa]", mathId_18(),0));
            resultModels.add(new StructuralDesignModel(19, "סוג הפלדה", "fv","[Mpa]", mathId_19(),0));
            // 16
            resultModels.add(new StructuralDesignModel(0, secondaryTitles.get(0), "","", "",0));
            resultModels.add(new StructuralDesignModel(20, "תכונת החתך", "α","", mathId_20(),0));
            // 18
            resultModels.add(new StructuralDesignModel(0, "", "","", "",0));
            resultModels.add(new StructuralDesignModel(24, "", "Nd","[KN]", mathId_24(),0));
            resultModels.add(new StructuralDesignModel(25, "", "Md","[KN]", mathId_25(),0));
            resultModels.add(new StructuralDesignModel(26, "", "Vd","[KN]", mathId_26(),0));
            // 22
            resultModels.add(new StructuralDesignModel(0, secondaryTitles.get(2), "","", "",0));
            resultModels.add(new StructuralDesignModel(28, "תסבולת ללחיצה בהתחשב בקריסה אוילרית", "Nd","[KN*m]", mathId_28(),0));
            resultModels.add(new StructuralDesignModel(29, "תסבולת ללחיצה בהתחשב בקריסה אוילרית", "Ncap","[KN*m]", mathId_29(),0));
            resultModels.add(new StructuralDesignModel(30, "תסבולת ללחיצה בהתחשב בקריסה אוילרית", "מקדם ביטחון","", mathId_30(),0));
            // 26
            resultModels.add(new StructuralDesignModel(0, secondaryTitles.get(3), "","", "",0));
            resultModels.add(new StructuralDesignModel(31, "תסבולת לגזירה", "Vd","[KN]", mathId_31(),0));
            resultModels.add(new StructuralDesignModel(32, "תסבולת לגזירה", "Av","[m^2]", mathId_32(),0));
            resultModels.add(new StructuralDesignModel(33, "תסבולת לגזירה", "Vcap","[KN]", mathId_33(),0));
            resultModels.add(new StructuralDesignModel(34, "תסבולת לגזירה", "מקדם ביטחון","", mathId_34(),0));
            // 31
            resultModels.add(new StructuralDesignModel(0, secondaryTitles.get(4), "","", "",0));
            resultModels.add(new StructuralDesignModel(35, "תסבולת לכפיפה (עבור D/tw<68)", "Md","[KN*m]", mathId_35(),0));
            resultModels.add(new StructuralDesignModel(36, "תסבולת לכפיפה (עבור D/tw<68)", "Mcap","[KN*m]", mathId_36(),0));
            resultModels.add(new StructuralDesignModel(37, "תסבולת לכפיפה (עבור D/tw<68)", "מקדם ביטחון","", mathId_37(),0));
            // 35
            resultModels.add(new StructuralDesignModel(0, secondaryTitles.get(5), "","", "",0));
            resultModels.add(new StructuralDesignModel(38, "כח צירי לתכן", "Nd","[KN]", mathId_38(),0));
            resultModels.add(new StructuralDesignModel(39, "מומנט תכן", "Md","[KNm]", mathId_39(),0));
            resultModels.add(new StructuralDesignModel(40, "תסבולת צירית ללא הפחתה", "Ncap","[KN]", mathId_40(),0));
            resultModels.add(new StructuralDesignModel(41, "תסבולת למומנט ללא הפחתה", "Mcap","[KNm]", mathId_41(),0));
            resultModels.add(new StructuralDesignModel(42, "פעולה משולבת", "","", mathId_42(),0));
            // 41
            resultModels.add(new StructuralDesignModel(0, secondaryTitles.get(6), "","", "",0));
            resultModels.add(new StructuralDesignModel(45, "תמירות", "λy","", mathId_45(),0));
            resultModels.add(new StructuralDesignModel(46, "תמירות מנורמלת", "λ ̅\uD835\uDC66","", mathId_46(),0));
            resultModels.add(new StructuralDesignModel(48, "לפי עקום קריסה", "αi","", mathId_48(),0));
            resultModels.add(new StructuralDesignModel(49, "", "ȵ","", mathId_49(),0));
            resultModels.add(new StructuralDesignModel(50, "מקדם הפחתה", "X","", mathId_50(),0));
            resultModels.add(new StructuralDesignModel(51, "תסבולת לכוח צירי", "Ncap","[KN]", mathId_51(),0));
            resultModels.add(new StructuralDesignModel(52, "תסבולת לכוח צירי", "Nd","[KN]", mathId_52(),0));
            resultModels.add(new StructuralDesignModel(53, "מקדם ביטחון", "F.S.","", mathId_53(),0));
            resultModels.add(new StructuralDesignModel(54, "כוח קריטי אלסטי", "Ncrx","", mathId_54(),0));
            // 51
            resultModels.add(new StructuralDesignModel(0, secondaryTitles.get(7), "","", "",0));
            resultModels.add(new StructuralDesignModel(57, "תמירות", "λy","", mathId_57(),0));
            resultModels.add(new StructuralDesignModel(58, "תמירות מנורמלת", "λ ̅\uD835\uDC66","", mathId_58(),0));
            resultModels.add(new StructuralDesignModel(60, "לפי עקום קריסה", "αi","", mathId_60(),0));
            resultModels.add(new StructuralDesignModel(61, "", "ȵ","", mathId_61(),0));
            resultModels.add(new StructuralDesignModel(62, "מקדם הפחתה", "X","", mathId_62(),0));
            resultModels.add(new StructuralDesignModel(63, "תסבולת לכוח צירי", "Ncap","[KN]", mathId_63(),0));
            resultModels.add(new StructuralDesignModel(64, "", "Nd","[KN]", mathId_64(),0));
            resultModels.add(new StructuralDesignModel(65, "מקדם ביטחון", "F.S.","", mathId_65(),0));
            // 60
            resultModels.add(new StructuralDesignModel(0, secondaryTitles.get(8), "","", "",0));
            resultModels.add(new StructuralDesignModel(67, "חישוב עזר לתכונות החומר ותכונות גיאומטריות", "Ct","[KN*m^2]", mathId_67(),0));
            resultModels.add(new StructuralDesignModel(68, "חישוב עזר לתכונות החומר ותכונות גיאומטריות", "Cwe","[KN*m^3]", mathId_68(),0));
            resultModels.add(new StructuralDesignModel(69, "מומנט ct", "Mcr,t","[KNm]", mathId_69(),0));
            resultModels.add(new StructuralDesignModel(70, "מומנט cw", "Mcr,w","[KNm]", mathId_70(),0));
            resultModels.add(new StructuralDesignModel(73, "מומנט קריטי", "Mcr","[KN*m]", mathId_73(),0));
            resultModels.add(new StructuralDesignModel(74, "מקדם הפחתה", "XL","", mathId_74(),0));
            resultModels.add(new StructuralDesignModel(75, "תסבולת למומנט", "ML","[KNm]", mathId_75(),0));
            resultModels.add(new StructuralDesignModel(76, "", "Md","[KNm]", mathId_76(),0));
            resultModels.add(new StructuralDesignModel(77, "מקדם ביטחון", "F.S","", mathId_77(),0));
            // 70
            resultModels.add(new StructuralDesignModel(0, "", "","", "",0));
            resultModels.add(new StructuralDesignModel(78, "", "Nd/Ncap,min","", mathId_78(),0));
            resultModels.add(new StructuralDesignModel(79, "", "Ncmin","[KN]", mathId_79(),0));
            resultModels.add(new StructuralDesignModel(80, "מקדם הפחתה", "Bx","", mathId_80(),0));
            resultModels.add(new StructuralDesignModel(81, "פעולה משולבת", "","", mathId_81(),0));
            setResultModelsPositions();
            return resultModels;
        }
    }

    private String mathId_2() {
        id_2_value = getRelevantValueFromTable(4);
        Log.d("checkMath", "mathId_2() -> id_2_value == " + id_2_value);
        return formatNumberDecimal(id_2_value);
    }

    private String mathId_3() {
        id_3_value = getRelevantValueFromTable(3);
        Log.d("checkMath", "mathId_3() -> id_3_value == " + id_3_value);
        return formatNumberDecimal(id_3_value);
    }

    private String mathId_4() {
        id_4_value = getRelevantValueFromTable(5);
        Log.d("checkMath", "mathId_4() -> id_4_value == " + id_4_value);
        return formatNumberDecimal(id_4_value);
    }

    private String mathId_5() {
        id_5_value = getRelevantValueFromTable(6);
        Log.d("checkMath", "mathId_5() -> id_5_value == " + id_5_value);
        return formatNumberDecimal(id_5_value);
    }

    private String mathId_6() {
        id_6_value = getRelevantValueFromTable(7);
        Log.d("checkMath", "mathId_6() -> id_6_value == " + id_6_value);
        return formatNumberDecimal(id_6_value);
    }

    private String mathId_7() {
        id_7_value = getRelevantValueFromTable(9);
        Log.d("checkMath", "mathId_7() -> id_7_value == " + id_7_value);
        return formatNumberDecimal(id_7_value);
    }

    private String mathId_8() {
        id_8_value = getRelevantValueFromTable(16);
        Log.d("checkMath", "mathId_8() -> id_8_value == " + id_8_value);
        return formatNumberDecimal(id_8_value);
    }

    private String mathId_9() {
        id_9_value = getRelevantValueFromTable(21);
        Log.d("checkMath", "mathId_9() -> id_9_value == " + id_9_value);
        return formatNumberDecimal(id_9_value);
    }

    private String mathId_10() {
        id_10_value = getRelevantValueFromTable(19);
        Log.d("checkMath", "mathId_10() -> id_10_value == " + id_10_value);
        return formatNumberDecimal(id_10_value);
    }

    private String mathId_11() {
        id_11_value = getRelevantValueFromTable(24);
        Log.d("checkMath", "mathId_11() -> id_11_value == " + id_11_value);
        return formatNumberDecimal(id_11_value);
    }

    private String mathId_12() {
        id_12_value = getRelevantValueFromTable(17);
        Log.d("checkMath", "mathId_12() -> id_12_value == " + id_12_value);
        return formatNumberDecimal(id_12_value);
    }

    private String mathId_13() {
        id_13_value = getRelevantValueFromTable(18);
        Log.d("checkMath", "mathId_13() -> id_13_value == " + id_13_value);
        return formatNumberDecimal(id_13_value);
    }

    private String mathId_16() {
        try {
            id_16_value = id_14_value;
            Log.d("checkMath", "mathId_16() -> id_16_value == " + id_16_value);
            if (Double.isNaN(id_16_value) || id_16_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_16_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_16() -> EXCEPTION -> " + e.getMessage());
            id_16_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_18() {
        id_18_value = id_14_value / id_17_value;
        Log.d("checkMath", "mathId_18() -> id_18_value == " + id_18_value);
        return formatNumberDecimal(id_18_value);
    }

    private String mathId_19() {
        id_19_value = 0.6 * id_18_value;
        Log.d("checkMath", "mathId_19() -> id_19_value == " + id_19_value);
        return formatNumberDecimal(id_19_value);
    }

    private String mathId_20() {
        Log.d("checkMath", "mathId_20() -> id_20_value == " + id_20_value);
        id_20_value = getRelevantValueCompareValId_14();
        return formatNumberDecimal(id_20_value);
    }

    private String mathId_24() {
        id_24_value = Math.abs(id_21_value * 1.4 * 1000);
        Log.d("checkMath", "mathId_24() -> id_24_value == " + id_24_value + "; id_21_value == " + id_21_value + "; firstMathPart == " + firstMathPart + "; secondMathPart == " + secondMathPart);
        return formatNumberDecimal(isTonSelected ? id_24_value / 10 : id_24_value);
    }

    private String mathId_25() {
        id_25_value = Math.abs(id_22_value * 1.4 * 1000);
        Log.d("checkMath", "mathId_25() -> id_25_value == " + id_25_value + "; firstMathPart == " + firstMathPart + "; secondMathPart == " + secondMathPart);
        return formatNumberDecimal(isTonSelected ? id_25_value / 10 : id_25_value);
    }

    private String mathId_26() {
        id_26_value = Math.abs(id_23_value * 1.4 * 1000);
        Log.d("checkMath", "mathId_26() -> id_26_value == " + id_26_value + "; id_23_value == " + id_23_value + "; firstMathPart == " + firstMathPart + "; secondMathPart == " + secondMathPart);
        return formatNumberDecimal(isTonSelected ? id_26_value / 10 : id_26_value);
    }

    private String mathId_28() {
        id_28_value = id_24_value * id_27_value;
        Log.d("checkMath", "mathId_28() -> id_28_value == " + id_28_value + "; id_24_value == " + id_24_value + "; id_27_value == " + id_27_value);
        return formatNumberDecimal(isTonSelected ? id_28_value / 10 : id_28_value);
    }

    private String mathId_29() {
        id_29_value = (id_7_value / Math.pow(100, 2)) * id_18_value * Math.pow(10, 3);
        Log.d("checkMath", "mathId_29() -> id_29_value == " + id_29_value + "; id_7_value == " + id_7_value + "; id_18_value == " + id_18_value);
        return formatNumberDecimal(isTonSelected ? id_29_value / 10 : id_29_value);
    }

    private String mathId_30() {
        try {
            id_30_value = id_29_value / id_28_value;
            Log.d("checkMath", "mathId_30() -> id_30_value == " + id_30_value);
            if (Double.isNaN(id_30_value) || id_30_value == Double.POSITIVE_INFINITY || id_30_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_30_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_30() -> EXCEPTION -> " + e.getMessage());
            id_30_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_31() {
        try {
            id_31_value = id_26_value * id_27_value;
            Log.d("checkMath", "mathId_31() -> id_31_value == " + id_31_value);
            if (Double.isNaN(id_31_value) || id_31_value == Double.POSITIVE_INFINITY || id_31_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_31_value / 10 : id_31_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_31() -> EXCEPTION -> " + e.getMessage());
            id_31_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_32() {
        try {
            id_32_value = id_4_value * id_2_value * Math.pow(1000, -2);
            Log.d("checkMath", "mathId_32() -> id_32_value == " + id_32_value);
            if (Double.isNaN(id_32_value) || id_32_value == Double.POSITIVE_INFINITY || id_32_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_32_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_32() -> EXCEPTION -> " + e.getMessage());
            id_32_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_33() {
        try {
            id_33_value = id_32_value * id_19_value * Math.pow(10, 3);
            Log.d("checkMath", "mathId_33() -> id_33_value == " + id_33_value);
            if (Double.isNaN(id_33_value) || id_33_value == Double.POSITIVE_INFINITY || id_33_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_33_value / 10 : id_33_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_33() -> EXCEPTION -> " + e.getMessage());
            id_33_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_34() {
        try {
            id_34_value = id_33_value / id_31_value;
            Log.d("checkMath", "mathId_34() -> id_34_value == " + id_34_value);
            if (Double.isNaN(id_34_value) || id_34_value == Double.POSITIVE_INFINITY || id_34_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_34_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_34() -> EXCEPTION -> " + e.getMessage());
            id_34_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }

    }

    private String mathId_35() {
        try {
            id_35_value = id_25_value * id_27_value;
            Log.d("checkMath", "mathId_35() -> id_35_value == " + id_35_value);
            if (Double.isNaN(id_38_value) || id_38_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_35_value / 10 : id_35_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_38() -> EXCEPTION -> " + e.getMessage());
            id_38_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_36() {
        try {
            if (id_33_value == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_36_value = id_31_value < 0.6 * id_33_value
                    ? Math.min(id_13_value * id_18_value * Math.pow(10, -3), 1.25 * id_18_value * id_12_value * Math.pow(10, -3))
                    : Math.min(Math.pow(10, -3) * id_18_value * (id_13_value - ((2.5 * id_31_value / id_33_value) - 1.5) * id_13_value), 1.25 * id_18_value * id_12_value * Math.pow(10, -3));
            Log.d("checkMath", "mathId_36() -> id_36_value == " + id_36_value);
            if (Double.isNaN(id_36_value) || id_36_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_36_value / 10 : id_36_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_36() -> EXCEPTION -> " + e.getMessage());
            id_36_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_37() {
        try {
            if (id_35_value == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_37_value = id_36_value / id_35_value;
            Log.d("checkMath", "mathId_37() -> id_37_value == " + id_37_value);
            if (Double.isNaN(id_37_value) || id_37_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_37_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_37() -> EXCEPTION -> " + e.getMessage());
            id_37_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_38() {
        try {
            id_38_value = id_28_value;
            Log.d("checkMath", "mathId_38() -> id_38_value == " + id_38_value);
            if (Double.isNaN(id_38_value) || id_38_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_38_value / 10 : id_38_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_38() -> EXCEPTION -> " + e.getMessage());
            id_38_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_39() {
        try {
            id_39_value = id_35_value;
            Log.d("checkMath", "mathId_39() -> id_39_value == " + id_39_value);
            if (Double.isNaN(id_39_value) || id_39_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_39_value / 10 : id_39_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_39() -> EXCEPTION -> " + e.getMessage());
            id_39_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_40() {
        try {
            id_40_value = id_29_value;
            Log.d("checkMath", "mathId_40() -> id_40_value == " + id_40_value);
            if (Double.isNaN(id_40_value) || id_40_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_40_value / 10 : id_40_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_40() -> EXCEPTION -> " + e.getMessage());
            id_40_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_41() {
        try {
            id_41_value = id_36_value;
            Log.d("checkMath", "mathId_41() -> id_41_value == " + id_41_value);
            if (Double.isNaN(id_41_value) || id_41_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_41_value / 10 : id_41_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_41() -> EXCEPTION -> " + e.getMessage());
            id_41_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_42() {
        try {
            id_42_value = (id_38_value / id_40_value) + (id_39_value / id_41_value);
            Log.d("checkMath", "mathId_42() -> id_42_value == " + id_42_value);
            if (Double.isNaN(id_42_value) || id_42_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_42_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_42() -> EXCEPTION -> " + e.getMessage());
            id_42_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_45() {
        try {
            id_45_value = id_43_value * id_44_value / id_11_value;
            Log.d("checkMath", "mathId_45() -> id_45_value == " + id_45_value);
            if (Double.isNaN(id_45_value) || id_45_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_45_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_45() -> EXCEPTION -> " + e.getMessage());
            id_45_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_46() {
        try {
            id_46_value = id_45_value * id_20_value;
            Log.d("checkMath", "mathId_46() -> id_46_value == " + id_46_value);
            if (Double.isNaN(id_46_value) || id_46_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_46_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_46() -> EXCEPTION -> " + e.getMessage());
            id_46_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }
    private String mathId_48() {
        try {
            id_48_value = getRelevantValueCompareABCD(id_47_position);
            Log.d("checkMath", "mathId_48() -> id_48_value == " + id_48_value);
            if (Double.isNaN(id_48_value) || id_48_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_48_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_48() -> EXCEPTION -> " + e.getMessage());
            id_48_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_49() {
        try {
            id_49_value = (1 + id_48_value * (id_46_value - 0.2) + Math.pow(id_46_value, 2)) / (2 * Math.pow(id_46_value, 2));
            Log.d("checkMath", "mathId_49() -> id_49_value == " + id_49_value);
            if (Double.isNaN(id_49_value) || id_49_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_49_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_49() -> EXCEPTION -> " + e.getMessage());
            id_49_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_50() {
        try {
            id_50_value = id_46_value < 0.2
                    ? 1
                    : (id_46_value > 3
                    ? 1 / (id_46_value * (id_46_value + id_48_value))
                    : ((id_46_value > 0.2 && id_46_value < 3)
                    ? (id_49_value - Math.pow((Math.pow(id_49_value, 2) - Math.pow((1/id_46_value), 2)), 0.5))
                    : Double.NEGATIVE_INFINITY));
            Log.d("checkMath", "mathId_50() -> id_50_value == " + id_50_value);
            if (Double.isNaN(id_50_value) || id_50_value == Double.POSITIVE_INFINITY || id_50_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_50_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_50() -> EXCEPTION -> " + e.getMessage());
            id_50_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_51() {
        try {
            id_51_value = id_50_value * id_29_value;
            Log.d("checkMath", "mathId_51() -> id_51_value == " + id_51_value);
            if (Double.isNaN(id_51_value) || id_51_value == Double.POSITIVE_INFINITY || id_51_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_51_value / 10 : id_51_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_51() -> EXCEPTION -> " + e.getMessage());
            id_51_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_52() {
        try {
            id_52_value = id_28_value;
            Log.d("checkMath", "mathId_52() -> id_52_value == " + id_52_value);
            if (Double.isNaN(id_52_value) || id_52_value == Double.POSITIVE_INFINITY || id_52_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_52_value / 10 : id_52_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_52() -> EXCEPTION -> " + e.getMessage());
            id_52_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_53() {
        try {
            id_53_value = id_51_value / id_52_value;
            Log.d("checkMath", "mathId_53() -> id_53_value == " + id_53_value);
            if (Double.isNaN(id_53_value) || id_53_value == Double.POSITIVE_INFINITY || id_53_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_53_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_53() -> EXCEPTION -> " + e.getMessage());
            id_53_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }
    private String mathId_54() {
        try {
            id_54_value = (Math.pow(Math.PI, 2) * id_15_value * Math.min(id_9_value, id_8_value) / Math.pow(id_44_value, 2));
            Log.d("checkMath", "mathId_54() -> id_54_value == " + id_54_value);
            if (Double.isNaN(id_54_value) || id_54_value == Double.POSITIVE_INFINITY || id_54_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_54_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_54() -> EXCEPTION -> " + e.getMessage());
            id_54_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_57() {
        try {
            id_57_value = id_55_value * id_56_value / id_10_value;
            Log.d("checkMath", "mathId_57() -> id_57_value == " + id_57_value);
            if (Double.isNaN(id_57_value) || id_57_value == Double.POSITIVE_INFINITY || id_57_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_57_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_57() -> EXCEPTION -> " + e.getMessage());
            id_57_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_58() {
        try {
            id_58_value = id_57_value * id_20_value;
            Log.d("checkMath", "mathId_58() -> id_58_value == " + id_58_value);
            if (Double.isNaN(id_58_value) || id_58_value == Double.POSITIVE_INFINITY || id_58_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_58_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_58() -> EXCEPTION -> " + e.getMessage());
            id_58_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_60() {
        try {
            id_60_value = getRelevantValueCompareABCD(id_59_position);
            Log.d("checkMath", "mathId_60() -> id_60_value == " + id_60_value);
            if (Double.isNaN(id_60_value) || id_60_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_60_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_60() -> EXCEPTION -> " + e.getMessage());
            id_60_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }
    private String mathId_61() {
        try {
            id_61_value = (1 + id_60_value * (id_58_value - 0.2) + Math.pow(id_58_value, 2)) / (2 * Math.pow(id_58_value, 2));
            Log.d("checkMath", "mathId_61() -> id_61_value == " + id_61_value);
            if (Double.isNaN(id_61_value) || id_61_value == Double.POSITIVE_INFINITY || id_61_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_61_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_61() -> EXCEPTION -> " + e.getMessage());
            id_61_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_62() {
        try {
            id_62_value = id_58_value < 0.2
                    ? 1
                    : (id_58_value > 3
                    ? 1 / (id_58_value * (+ id_60_value))
                    : ((id_58_value > 0.2 && id_58_value < 3)
                    ? (id_61_value - Math.pow(Math.pow(id_61_value, 2) - Math.pow(1 / id_58_value, 2), 0.5)) : Double.NaN));
            Log.d("checkMath", "mathId_62() -> id_62_value == " + id_62_value);
            if (Double.isNaN(id_62_value) || id_62_value == Double.POSITIVE_INFINITY || id_62_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_62_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_62() -> EXCEPTION -> " + e.getMessage());
            id_62_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_63() {
        try {
            id_63_value = id_62_value * id_29_value;
            Log.d("checkMath", "mathId_63() -> id_63_value == " + id_63_value);
            if (Double.isNaN(id_63_value) || id_63_value == Double.POSITIVE_INFINITY || id_63_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_63_value / 10 : id_63_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_63() -> EXCEPTION -> " + e.getMessage());
            id_63_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_64() {
        try {
            id_64_value = id_28_value;
            Log.d("checkMath", "mathId_64() -> id_64_value == " + id_64_value);
            if (Double.isNaN(id_64_value) || id_64_value == Double.POSITIVE_INFINITY || id_64_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_64_value / 10 : id_64_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_64() -> EXCEPTION -> " + e.getMessage());
            id_64_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_65() {
        try {
            id_65_value = id_63_value / id_64_value;
            Log.d("checkMath", "mathId_65() -> id_65_value == " + id_65_value);
            if (Double.isNaN(id_65_value) || id_65_value == Double.POSITIVE_INFINITY || id_65_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_65_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_65() -> EXCEPTION -> " + e.getMessage());
            id_65_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_67() {
        try {
            id_67_value = getRelevantValueFromTable(31);
            Log.d("checkMath", "mathId_67() -> id_67_value == " + id_67_value);
            if (Double.isNaN(id_67_value) || id_67_value == Double.POSITIVE_INFINITY || id_67_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_67_value / 10 : id_67_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_67() -> EXCEPTION -> " + e.getMessage());
            id_67_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_68() {
        try {
            id_68_value = getRelevantValueFromTable(32);
            Log.d("checkMath", "mathId_68() -> id_68_value == " + id_68_value);
            if (Double.isNaN(id_68_value) || id_68_value == Double.POSITIVE_INFINITY || id_68_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_68_value / 10 : id_68_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_68() -> EXCEPTION -> " + e.getMessage());
            id_68_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_69() {
        try {
            id_69_value = id_67_value / id_66_value;
            Log.d("checkMath", "mathId_69() -> id_69_value == " + id_69_value);
            if (Double.isNaN(id_69_value) || id_69_value == Double.POSITIVE_INFINITY || id_69_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_69_value / 10 : id_69_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_69() -> EXCEPTION -> " + e.getMessage());
            id_69_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_70() {
        try {
            id_70_value = id_68_value / Math.pow(id_66_value, 2);
            Log.d("checkMath", "mathId_70() -> id_70_value == " + id_70_value);
            if (Double.isNaN(id_70_value) || id_70_value == Double.POSITIVE_INFINITY || id_70_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_70_value / 10 : id_70_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_70() -> EXCEPTION -> " + e.getMessage());
            id_70_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_73() {
        try {
            id_73_value = (1 / id_72_value) * Math.pow((Math.pow(id_69_value, 2) + Math.pow(id_70_value, 2)), 0.5);
            Log.d("checkMath", "mathId_73() -> id_73_value == " + id_73_value);
            if (Double.isNaN(id_73_value) || id_73_value == Double.POSITIVE_INFINITY || id_73_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_73_value / 10 : id_73_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_73() -> EXCEPTION -> " + e.getMessage());
            id_73_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_74() {
        try {
            id_74_value = Math.pow((1 + (Math.pow(1.08 * id_36_value / id_73_value, id_71_value))), (-1 / id_71_value));
            Log.d("checkMath", "mathId_74() -> id_74_value == " + id_74_value + "");
            if (Double.isNaN(id_74_value) || id_74_value == Double.POSITIVE_INFINITY || id_74_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_74_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_74() -> EXCEPTION -> " + e.getMessage());
            id_74_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_75() {
        try {
            id_75_value = id_74_value * id_36_value;
            Log.d("checkMath", "mathId_75() -> id_75_value == " + id_75_value);
            if (Double.isNaN(id_75_value) || id_75_value == Double.POSITIVE_INFINITY || id_75_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_75_value / 10 : id_75_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_75() -> EXCEPTION -> " + e.getMessage());
            id_75_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_76() {
        try {
            id_76_value = id_35_value;
            Log.d("checkMath", "mathId_76() -> id_76_value == " + id_76_value);
            if (Double.isNaN(id_76_value) || id_76_value == Double.POSITIVE_INFINITY || id_76_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_76_value / 10 : id_76_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_76() -> EXCEPTION -> " + e.getMessage());
            id_76_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_77() {
        try {
            id_77_value = id_75_value / id_76_value;
            Log.d("checkMath", "mathId_77() -> id_77_value == " + id_77_value);
            if (Double.isNaN(id_77_value) || id_77_value == Double.POSITIVE_INFINITY || id_77_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_77_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_77() -> EXCEPTION -> " + e.getMessage());
            id_77_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_78() {
        try {
            id_78_value = id_38_value / Math.min(id_51_value, id_63_value);
            Log.d("checkMath", "mathId_78() -> id_78_value == " + id_78_value);
            if (Double.isNaN(id_78_value) || id_78_value == Double.POSITIVE_INFINITY || id_78_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_78_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_78() -> EXCEPTION -> " + e.getMessage());
            id_78_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_79() {
        try {
            id_79_value = Math.min(id_51_value, id_63_value);
            Log.d("checkMath", "mathId_79() -> id_79_value == " + id_79_value);
            if (Double.isNaN(id_79_value) || id_79_value == Double.POSITIVE_INFINITY || id_79_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(isTonSelected ? id_79_value / 10 : id_79_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_79() -> EXCEPTION -> " + e.getMessage());
            id_79_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_80() {
        try {
            id_80_value = Math.max((id_72_value / (1 - id_28_value / id_54_value)),1);
            Log.d("checkMath", "mathId_80() -> id_80_value == " + id_80_value);
            if (Double.isNaN(id_80_value) || id_80_value == Double.POSITIVE_INFINITY || id_80_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_80_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_80() -> EXCEPTION -> " + e.getMessage());
            id_80_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_81() {
        try {
            id_81_value = (id_28_value / id_79_value) + id_80_value * id_35_value / id_75_value;
            Log.d("checkMath", "mathId_81() -> id_81_value == " + id_81_value + "; id_80_value == " + id_80_value + "; id_79_value == " + id_79_value + "; id_75_value == " + id_75_value + "; id_35_value == " + id_35_value + "; id_28_value == " + id_28_value);
            if (Double.isNaN(id_81_value) || id_81_value == Double.POSITIVE_INFINITY || id_81_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_81_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_81() -> EXCEPTION -> " + e.getMessage());
            id_81_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1031() {
        try {
            id_1031_value = mathId_31_series(id_1021_value, id_1026_value);
            Log.d("checkMath", "mathId_1031() -> id_1031_value == " + id_1031_value);
            if (Double.isNaN(id_1031_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1031_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1031() -> EXCEPTION -> " + e.getMessage());
            id_1031_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1131() {
        try {
            id_1131_value = mathId_31_series(id_1121_value, id_1126_value);
            Log.d("checkMath", "mathId_1131() -> id_1131_value == " + id_1131_value);
            if (Double.isNaN(id_1131_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1131_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1131() -> EXCEPTION -> " + e.getMessage());
            id_1131_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1231() {
        try {
            id_1231_value = mathId_31_series(id_1221_value, id_1226_value);
            Log.d("checkMath", "mathId_1231() -> id_1231_value == " + id_1231_value);
            if (Double.isNaN(id_1231_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1231_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1231() -> EXCEPTION -> " + e.getMessage());
            id_1231_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1331() {
        try {
            id_1331_value = mathId_31_series(id_1321_value, id_1326_value);
            Log.d("checkMath", "mathId_1331() -> id_1331_value == " + id_1331_value);
            if (Double.isNaN(id_1331_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1331_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1331() -> EXCEPTION -> " + e.getMessage());
            id_1331_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1431() {
        try {
            id_1431_value = mathId_31_series(id_1421_value, id_1426_value);
            Log.d("checkMath", "mathId_1431() -> id_1431_value == " + id_1431_value);
            if (Double.isNaN(id_1431_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1431_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1431() -> EXCEPTION -> " + e.getMessage());
            id_1431_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1531() {
        try {
            id_1531_value = mathId_31_series(id_1521_value, id_1526_value);
            Log.d("checkMath", "mathId_1531() -> id_1531_value == " + id_1531_value);
            if (Double.isNaN(id_1531_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1531_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1531() -> EXCEPTION -> " + e.getMessage());
            id_1531_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1631() {
        try {
            id_1631_value = mathId_31_series(id_1621_value, id_1626_value);
            Log.d("checkMath", "mathId_1631() -> id_1631_value == " + id_1631_value);
            if (Double.isNaN(id_1631_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1631_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1631() -> EXCEPTION -> " + e.getMessage());
            id_1631_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1731() {
        try {
            id_1731_value = mathId_31_series(id_1721_value, id_1726_value);
            Log.d("checkMath", "mathId_1731() -> id_1731_value == " + id_1731_value);
            if (Double.isNaN(id_1731_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1731_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1731() -> EXCEPTION -> " + e.getMessage());
            id_1731_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1831() {
        try {
            id_1831_value = mathId_31_series(id_1821_value, id_1826_value);
            Log.d("checkMath", "mathId_1831() -> id_1831_value == " + id_1831_value);
            if (Double.isNaN(id_1831_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1831_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1831() -> EXCEPTION -> " + e.getMessage());
            id_1831_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1931() {
        try {
            id_1931_value = mathId_31_series(id_1921_value, id_1926_value);
            Log.d("checkMath", "mathId_1931() -> id_1931_value == " + id_1931_value);
            if (Double.isNaN(id_1931_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1931_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1931() -> EXCEPTION -> " + e.getMessage());
            id_1931_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2031() {
        try {
            id_2031_value = mathId_31_series(id_2021_value, id_2026_value);
            Log.d("checkMath", "mathId_2031() -> id_2031_value == " + id_2031_value);
            if (Double.isNaN(id_2031_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2031_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2031() -> EXCEPTION -> " + e.getMessage());
            id_2031_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2131() {
        try {
            id_2131_value = mathId_31_series(id_2121_value, id_2126_value);
            Log.d("checkMath", "mathId_2131() -> id_2131_value == " + id_2131_value);
            if (Double.isNaN(id_2131_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2131_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2131() -> EXCEPTION -> " + e.getMessage());
            id_2131_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2231() {
        try {
            id_2231_value = mathId_31_series(id_2221_value, id_2226_value);
            Log.d("checkMath", "mathId_2231() -> id_2231_value == " + id_2231_value);
            if (Double.isNaN(id_2231_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2231_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2231() -> EXCEPTION -> " + e.getMessage());
            id_2231_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2331() {
        try {
            id_2331_value = mathId_31_series(id_2321_value, id_2326_value);
            Log.d("checkMath", "mathId_2331() -> id_2331_value == " + id_2331_value);
            if (Double.isNaN(id_2331_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2331_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2331() -> EXCEPTION -> " + e.getMessage());
            id_2331_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2431() {
        try {
            id_2431_value = mathId_31_series(id_2421_value, id_2426_value);
            Log.d("checkMath", "mathId_2431() -> id_2431_value == " + id_2431_value);
            if (Double.isNaN(id_2431_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2431_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2431() -> EXCEPTION -> " + e.getMessage());
            id_2431_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2531() {
        try {
            id_2531_value = mathId_31_series(id_2521_value, id_2526_value);
            Log.d("checkMath", "mathId_2531() -> id_2531_value == " + id_2531_value);
            if (Double.isNaN(id_2531_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2531_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2531() -> EXCEPTION -> " + e.getMessage());
            id_2531_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2631() {
        try {
            id_2631_value = mathId_31_series(id_2621_value, id_2626_value);
            Log.d("checkMath", "mathId_2631() -> id_2631_value == " + id_2631_value);
            if (Double.isNaN(id_2631_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2631_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2631() -> EXCEPTION -> " + e.getMessage());
            id_2631_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2731() {
        try {
            id_2731_value = mathId_31_series(id_2721_value, id_2726_value);
            Log.d("checkMath", "mathId_2731() -> id_2731_value == " + id_2731_value);
            if (Double.isNaN(id_2731_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2731_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2731() -> EXCEPTION -> " + e.getMessage());
            id_2731_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2831() {
        try {
            id_2831_value = mathId_31_series(id_2821_value, id_2826_value);
            Log.d("checkMath", "mathId_2831() -> id_2831_value == " + id_2831_value);
            if (Double.isNaN(id_2831_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2831_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2831() -> EXCEPTION -> " + e.getMessage());
            id_2831_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2931() {
        try {
            id_2931_value = mathId_31_series(id_2921_value, id_2926_value);
            Log.d("checkMath", "mathId_2931() -> id_2931_value == " + id_2931_value);
            if (Double.isNaN(id_2931_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2931_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2931() -> EXCEPTION -> " + e.getMessage());
            id_2931_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_3031() {
        try {
            id_3031_value = mathId_31_series(id_3021_value, id_3026_value);
            Log.d("checkMath", "mathId_3031() -> id_3031_value == " + id_3031_value);
            if (Double.isNaN(id_3031_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_3031_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_3031() -> EXCEPTION -> " + e.getMessage());
            id_3031_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_3131() {
        try {
            id_3131_value = mathId_31_series(id_3121_value, id_3126_value);
            Log.d("checkMath", "mathId_3131() -> id_3131_value == " + id_3131_value);
            if (Double.isNaN(id_3131_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_3131_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_3131() -> EXCEPTION -> " + e.getMessage());
            id_3131_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_3231() {
        try {
            id_3231_value = mathId_31_series(id_3221_value, id_3226_value);
            Log.d("checkMath", "mathId_3231() -> id_3231_value == " + id_3231_value);
            if (Double.isNaN(id_3231_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_3231_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_3231() -> EXCEPTION -> " + e.getMessage());
            id_3231_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_3331() {
        try {
            id_3331_value = mathId_31_series(id_3321_value, id_3326_value);
            Log.d("checkMath", "mathId_3331() -> id_3331_value == " + id_3331_value);
            if (Double.isNaN(id_3331_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_3331_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_3331() -> EXCEPTION -> " + e.getMessage());
            id_3331_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private double mathId_31_series(double series_21_val, double series_26_val) {
        double id_31_series;
        try {
            id_31_series = (Math.PI * id_15_value * 1000 * Math.sqrt(series_21_val * Math.pow(100, -4) * series_26_val * Math.pow(100, -4))) / (Math.sqrt(2.6));
            Log.d("checkMath", "mathId_31_series() -> id_31_series == " + id_31_series);
            if (Double.isNaN(id_31_series) || id_31_series == Double.POSITIVE_INFINITY || id_31_series == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return id_31_series;
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_31_series() -> EXCEPTION -> " + e.getMessage());
            return Double.NaN;
        }
    }

    private String mathId_1032() {
        try {
            id_1032_value = mathId_32_series(id_1021_value, id_1004_value, id_1006_value);
            Log.d("checkMath", "mathId_1032() -> id_1032_value == " + id_1032_value + "; id_1021_value == " + id_1021_value + "; id_1004_value == " + id_1004_value + "; id_1006_value == " + id_1006_value);
            if (Double.isNaN(id_1032_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1032_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1032() -> EXCEPTION -> " + e.getMessage());
            id_1032_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1132() {
        try {
            id_1132_value = mathId_32_series(id_1121_value, id_1104_value, id_1106_value);
            Log.d("checkMath", "mathId_1132() -> id_1132_value == " + id_1132_value);
            if (Double.isNaN(id_1132_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1132_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1132() -> EXCEPTION -> " + e.getMessage());
            id_1132_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1232() {
        try {
            id_1232_value = mathId_32_series(id_1221_value, id_1204_value, id_1206_value);
            Log.d("checkMath", "mathId_1232() -> id_1232_value == " + id_1232_value);
            if (Double.isNaN(id_1232_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1232_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1232() -> EXCEPTION -> " + e.getMessage());
            id_1232_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1332() {
        try {
            id_1332_value = mathId_32_series(id_1321_value, id_1304_value, id_1306_value);
            Log.d("checkMath", "mathId_1332() -> id_1332_value == " + id_1332_value);
            if (Double.isNaN(id_1332_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1332_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1332() -> EXCEPTION -> " + e.getMessage());
            id_1332_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1432() {
        try {
            id_1432_value = mathId_32_series(id_1421_value, id_1404_value, id_1406_value);
            Log.d("checkMath", "mathId_1432() -> id_1432_value == " + id_1432_value);
            if (Double.isNaN(id_1432_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1432_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1432() -> EXCEPTION -> " + e.getMessage());
            id_1432_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1532() {
        try {
            id_1532_value = mathId_32_series(id_1521_value, id_1504_value, id_1506_value);
            Log.d("checkMath", "mathId_1532() -> id_1532_value == " + id_1532_value);
            if (Double.isNaN(id_1532_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1532_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1532() -> EXCEPTION -> " + e.getMessage());
            id_1532_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1632() {
        try {
            id_1632_value = mathId_32_series(id_1621_value, id_1604_value, id_1606_value);
            Log.d("checkMath", "mathId_1632() -> id_1632_value == " + id_1632_value);
            if (Double.isNaN(id_1632_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1632_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1632() -> EXCEPTION -> " + e.getMessage());
            id_1632_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1732() {
        try {
            id_1732_value = mathId_32_series(id_1721_value, id_1704_value, id_1706_value);
            Log.d("checkMath", "mathId_1732() -> id_1732_value == " + id_1732_value);
            if (Double.isNaN(id_1732_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1732_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1732() -> EXCEPTION -> " + e.getMessage());
            id_1732_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1832() {
        try {
            id_1832_value = mathId_32_series(id_1821_value, id_1804_value, id_1806_value);
            Log.d("checkMath", "mathId_1832() -> id_1832_value == " + id_1832_value);
            if (Double.isNaN(id_1832_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1832_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1832() -> EXCEPTION -> " + e.getMessage());
            id_1832_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_1932() {
        try {
            id_1932_value = mathId_32_series(id_1921_value, id_1904_value, id_1906_value);
            Log.d("checkMath", "mathId_1932() -> id_1932_value == " + id_1932_value);
            if (Double.isNaN(id_1932_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_1932_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_1932() -> EXCEPTION -> " + e.getMessage());
            id_1932_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2032() {
        try {
            id_2032_value = mathId_32_series(id_2021_value, id_2004_value, id_2006_value);
            Log.d("checkMath", "mathId_2032() -> id_2032_value == " + id_2032_value);
            if (Double.isNaN(id_2032_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2032_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2032() -> EXCEPTION -> " + e.getMessage());
            id_2032_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2132() {
        try {
            id_2132_value = mathId_32_series(id_2121_value, id_2104_value, id_2106_value);
            Log.d("checkMath", "mathId_2132() -> id_2132_value == " + id_2132_value);
            if (Double.isNaN(id_2132_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2132_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2132() -> EXCEPTION -> " + e.getMessage());
            id_2132_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2232() {
        try {
            id_2232_value = mathId_32_series(id_2221_value, id_2204_value, id_2206_value);
            Log.d("checkMath", "mathId_2232() -> id_2232_value == " + id_2232_value);
            if (Double.isNaN(id_2232_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2232_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2232() -> EXCEPTION -> " + e.getMessage());
            id_2232_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2332() {
        try {
            id_2332_value = mathId_32_series(id_2321_value, id_2304_value, id_2306_value);
            Log.d("checkMath", "mathId_2332() -> id_2332_value == " + id_2332_value);
            if (Double.isNaN(id_2332_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2332_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2332() -> EXCEPTION -> " + e.getMessage());
            id_2332_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2432() {
        try {
            id_2432_value = mathId_32_series(id_2421_value, id_2404_value, id_2406_value);
            Log.d("checkMath", "mathId_2432() -> id_2432_value == " + id_2432_value);
            if (Double.isNaN(id_2432_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2432_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2432() -> EXCEPTION -> " + e.getMessage());
            id_2432_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2532() {
        try {
            id_2532_value = mathId_32_series(id_2521_value, id_2504_value, id_2506_value);
            Log.d("checkMath", "mathId_2532() -> id_2532_value == " + id_2532_value);
            if (Double.isNaN(id_2532_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2532_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2532() -> EXCEPTION -> " + e.getMessage());
            id_2532_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2632() {
        try {
            id_2632_value = mathId_32_series(id_2621_value, id_2604_value, id_2606_value);
            Log.d("checkMath", "mathId_2632() -> id_2632_value == " + id_2632_value);
            if (Double.isNaN(id_2632_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2632_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2632() -> EXCEPTION -> " + e.getMessage());
            id_2632_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2732() {
        try {
            id_2732_value = mathId_32_series(id_2721_value, id_2704_value, id_2706_value);
            Log.d("checkMath", "mathId_2732() -> id_2732_value == " + id_2732_value);
            if (Double.isNaN(id_2732_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2732_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2732() -> EXCEPTION -> " + e.getMessage());
            id_2732_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2832() {
        try {
            id_2832_value = mathId_32_series(id_2821_value, id_2804_value, id_2806_value);
            Log.d("checkMath", "mathId_2832() -> id_2832_value == " + id_2832_value);
            if (Double.isNaN(id_2832_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2832_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2832() -> EXCEPTION -> " + e.getMessage());
            id_2832_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_2932() {
        try {
            id_2932_value = mathId_32_series(id_2921_value, id_2904_value, id_2906_value);
            Log.d("checkMath", "mathId_2932() -> id_2932_value == " + id_2932_value);
            if (Double.isNaN(id_2932_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_2932_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_2932() -> EXCEPTION -> " + e.getMessage());
            id_2932_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_3032() {
        try {
            id_3032_value = mathId_32_series(id_3021_value, id_3004_value, id_3006_value);
            Log.d("checkMath", "mathId_3032() -> id_3032_value == " + id_3032_value);
            if (Double.isNaN(id_3032_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_3032_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_3032() -> EXCEPTION -> " + e.getMessage());
            id_3032_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_3132() {
        try {
            id_3132_value = mathId_32_series(id_3121_value, id_3104_value, id_3106_value);
            Log.d("checkMath", "mathId_3132() -> id_3132_value == " + id_3132_value);
            if (Double.isNaN(id_3132_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_3132_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_3132() -> EXCEPTION -> " + e.getMessage());
            id_3132_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_3232() {
        try {
            id_3232_value = mathId_32_series(id_3221_value, id_3204_value, id_3206_value);
            Log.d("checkMath", "mathId_3232() -> id_3232_value == " + id_3232_value);
            if (Double.isNaN(id_3232_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_3232_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_3232() -> EXCEPTION -> " + e.getMessage());
            id_3232_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_3332() {
        try {
            id_3332_value = mathId_32_series(id_3321_value, id_3304_value, id_3306_value);
            Log.d("checkMath", "mathId_3332() -> id_3332_value == " + id_3332_value);
            if (Double.isNaN(id_3332_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_3332_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_3332() -> EXCEPTION -> " + e.getMessage());
            id_3332_value  = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private double mathId_32_series(double series_21_val, double series_04_val, double series_06_val) {
        double id_32_series;
        try {
            id_32_series = (Math.pow(Math.PI, 2) * id_15_value * 1000 * series_21_val * Math.pow(100, -4) * ((series_04_val * Math.pow(1000, -1)) - (series_06_val * Math.pow(1000, -1))))/2;
            Log.d("checkMath", "mathId_32_series() -> id_32_series == " + id_32_series + "; id_15_value == " + id_15_value + "; series_21_val == " + series_21_val + "; series_04_val == " + series_04_val + "; series_06_val == " + series_06_val);
            if (Double.isNaN(id_32_series) || id_32_series == Double.POSITIVE_INFINITY || id_32_series == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return id_32_series;
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_32_series() -> EXCEPTION -> " + e.getMessage());
            return Double.NaN;
        }
    }

    public void set_31_or_32_seriesArrayValue(boolean isForSet_31_series, int id_1_position){
        double returnValue;
        switch (id_1_position){
            case 1:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_1131()) : Double.parseDouble(mathId_1132());
                break;
            case 2:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_1231()) : Double.parseDouble(mathId_1232());
                break;
            case 3:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_1331()) : Double.parseDouble(mathId_1232());
                break;
            case 4:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_1431()) : Double.parseDouble(mathId_1232());
                break;
            case 5:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_1531()) : Double.parseDouble(mathId_1532());
                break;
            case 6:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_1631()) : Double.parseDouble(mathId_1632());
                break;
            case 7:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_1731()) : Double.parseDouble(mathId_1732());
                break;
            case 8:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_1831()) : Double.parseDouble(mathId_1832());
                break;
            case 9:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_1931()) : Double.parseDouble(mathId_1932());
                break;
            case 10:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_2031()) : Double.parseDouble(mathId_2032());
                break;
            case 11:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_2131()) : Double.parseDouble(mathId_2132());
                break;
            case 12:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_2231()) : Double.parseDouble(mathId_2232());
                break;
            case 13:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_2331()) : Double.parseDouble(mathId_2332());
                break;
            case 14:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_2431()) : Double.parseDouble(mathId_2432());
                break;
            case 15:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_2531()) : Double.parseDouble(mathId_2532());
                break;
            case 16:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_2631()) : Double.parseDouble(mathId_2632());
                break;
            case 17:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_2731()) : Double.parseDouble(mathId_2732());
                break;
            case 18:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_2831()) : Double.parseDouble(mathId_2832());
                break;
            case 19:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_2931()) : Double.parseDouble(mathId_2932());
                break;
            case 20:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_3031()) : Double.parseDouble(mathId_3032());
                break;
            case 21:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_3131()) : Double.parseDouble(mathId_3132());
                break;
            case 22:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_3231()) : Double.parseDouble(mathId_3232());
                break;
            case 23:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_3331()) : Double.parseDouble(mathId_3332());
                break;
            case 0: default:
                returnValue = isForSet_31_series ? Double.parseDouble(mathId_1031()) : Double.parseDouble(mathId_1032());
                break;
        }
        if (isForSet_31_series){
            valuesOfColumn_31_AList.add(SubCategoriesManagerActivity.id_1_position, returnValue);
        } else {
            valuesOfColumn_32_AList.add(SubCategoriesManagerActivity.id_1_position, returnValue);
        }
        Log.d("checkMath", "math_31_or_32_seriesValue() -> returnValue == " + returnValue);
    }

    private void set_31_or_32_seriesArrayValue(int id_1_position){
        set_31_or_32_seriesArrayValue(true, id_1_position);
        set_31_or_32_seriesArrayValue(false, id_1_position);
    }

    public void setAllAdapters() {
        setAdapter(true, initModels(true));
        setAdapter(false, initModels(false));
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        Log.d("numberChangedListener", "CanopyLengthsCategory{} -> valueItemNumber == " + valueItemNumber + "; valueItemId == " + valueItemId + "; numberPickerPosition == " + spinnerPosition);
        switch (valueItemId){
            case 1:
                id_1_position = spinnerPosition;
                id_1_value = Double.parseDouble(subCategoryActiveId == 0 ? getIPN_stringValues()[spinnerPosition] : getHebAndHea_stringValues()[spinnerPosition]);
                set_31_or_32_seriesArrayValue(id_1_position);
                setRelevantResultItem_value(2, mathId_2(), "");
                setRelevantResultItem_value(3, mathId_3(), "");
                setRelevantResultItem_value(4, mathId_4(), "");
                setRelevantResultItem_value(5, mathId_5(), "");
                setRelevantResultItem_value(6, mathId_6(), "");
                setRelevantResultItem_value(7, mathId_7(), "");
                setRelevantResultItem_value(8, mathId_8(), "");
                setRelevantResultItem_value(9, mathId_9(), "");
                setRelevantResultItem_value(10, mathId_10(), "");
                setRelevantResultItem_value(11, mathId_11(), "");
                setRelevantResultItem_value(12, mathId_12(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(29, mathId_29(), "");
                setRelevantResultItem_value(30, mathId_30(), "");
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(33, mathId_33(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(36, mathId_36(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(40, mathId_40(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(42, mathId_42(), "");
                setRelevantResultItem_value(45, mathId_45(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(50, mathId_50(), "");
                setRelevantResultItem_value(51, mathId_51(), "");
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(54, mathId_54(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(58, mathId_58(), "");
                setRelevantResultItem_value(58, mathId_58(), "");
                setRelevantResultItem_value(61, mathId_61(), "");
                setRelevantResultItem_value(62, mathId_62(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(67, mathId_67(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(69, mathId_69(), "");
                setRelevantResultItem_value(70, mathId_70(), "");
                setRelevantResultItem_value(73, mathId_73(), "");
                setRelevantResultItem_value(74, mathId_74(), "");
                setRelevantResultItem_value(75, mathId_75(), "");
                setRelevantResultItem_value(77, mathId_77(), "");
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(80, mathId_80(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                break;
            case 14:
                id_14_position = spinnerPosition;
                id_14_value = Double.parseDouble(getSteelType_stringValues()[spinnerPosition]);
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(29, mathId_29(), "");
                setRelevantResultItem_value(30, mathId_30(), "");
                setRelevantResultItem_value(33, mathId_33(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(36, mathId_36(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(40, mathId_40(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(42, mathId_42(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(50, mathId_50(), "");
                setRelevantResultItem_value(51, mathId_51(), "");
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(58, mathId_58(), "");
                setRelevantResultItem_value(61, mathId_61(), "");
                setRelevantResultItem_value(62, mathId_62(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(74, mathId_74(), "");
                setRelevantResultItem_value(75, mathId_75(), "");
                setRelevantResultItem_value(77, mathId_77(), "");
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                break;
            case 15:
                id_15_value = valueItemNumber;
                set_31_or_32_seriesArrayValue(id_1_position);
                setRelevantResultItem_value(54, mathId_54(), "");
                setRelevantResultItem_value(67, mathId_67(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(69, mathId_69(), "");
                setRelevantResultItem_value(70, mathId_70(), "");
                setRelevantResultItem_value(73, mathId_73(), "");
                setRelevantResultItem_value(74, mathId_74(), "");
                setRelevantResultItem_value(75, mathId_75(), "");
                setRelevantResultItem_value(77, mathId_77(), "");
                setRelevantResultItem_value(80, mathId_80(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                break;
            case 17:
                id_17_value = valueItemNumber;
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(29, mathId_29(), "");
                setRelevantResultItem_value(30, mathId_30(), "");
                setRelevantResultItem_value(33, mathId_33(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(36, mathId_36(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(40, mathId_40(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(42, mathId_42(), "");
                setRelevantResultItem_value(51, mathId_51(), "");
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(74, mathId_74(), "");
                setRelevantResultItem_value(75, mathId_75(), "");
                setRelevantResultItem_value(77, mathId_77(), "");
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(81, mathId_81(), "");

                break;
            case 21:
                id_21_value = valueItemNumber;
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(28, mathId_28(), "");
                setRelevantResultItem_value(30, mathId_30(), "");
                setRelevantResultItem_value(38, mathId_38(), "");
                setRelevantResultItem_value(42, mathId_42(), "");
                setRelevantResultItem_value(52, mathId_52(), "");
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(64, mathId_64(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(80, mathId_80(), "");
                setRelevantResultItem_value(81, mathId_81(), "");

                break;
            case 22:
                id_22_value = valueItemNumber;
                setRelevantResultItem_value(25, mathId_25(), "");
                setRelevantResultItem_value(35, mathId_35(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(39, mathId_39(), "");
                setRelevantResultItem_value(42, mathId_42(), "");
                setRelevantResultItem_value(76, mathId_76(), "");
                setRelevantResultItem_value(77, mathId_77(), "");
                setRelevantResultItem_value(81, mathId_81(), "");

                break;
            case 23:
                id_23_value = valueItemNumber;
                setRelevantResultItem_value(26, mathId_26(), "");
                setRelevantResultItem_value(31, mathId_31(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(36, mathId_36(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(42, mathId_42(), "");
                setRelevantResultItem_value(74, mathId_74(), "");
                setRelevantResultItem_value(75, mathId_75(), "");
                setRelevantResultItem_value(77, mathId_77(), "");
                setRelevantResultItem_value(81, mathId_81(), "");

                break;
            case 27:
                id_27_value = valueItemNumber;
                setRelevantResultItem_value(28, mathId_28(), "");
                setRelevantResultItem_value(30, mathId_30(), "");
                setRelevantResultItem_value(31, mathId_31(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(35, mathId_35(), "");
                setRelevantResultItem_value(36, mathId_36(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(38, mathId_38(), "");
                setRelevantResultItem_value(39, mathId_39(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(42, mathId_42(), "");
                setRelevantResultItem_value(52, mathId_52(), "");
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(64, mathId_64(), "");
                setRelevantResultItem_value(74, mathId_74(), "");
                setRelevantResultItem_value(75, mathId_75(), "");
                setRelevantResultItem_value(76, mathId_76(), "");
                setRelevantResultItem_value(77, mathId_77(), "");
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(80, mathId_80(), "");
                setRelevantResultItem_value(81, mathId_81(), "");

                break;
            case 43:
                id_43_value = valueItemNumber;
                setRelevantResultItem_value(45, mathId_45(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(50, mathId_50(), "");
                setRelevantResultItem_value(51, mathId_51(), "");
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(81, mathId_81(), "");

                break;
            case 44:
                id_44_value = valueItemNumber;
                setRelevantResultItem_value(45, mathId_45(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(50, mathId_50(), "");
                setRelevantResultItem_value(51, mathId_51(), "");
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(54, mathId_54(), "");
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(80, mathId_80(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                break;
            case 47:
                id_47_position = spinnerPosition;
                setRelevantResultItem_value(48, mathId_48(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(50, mathId_50(), "");
                setRelevantResultItem_value(51, mathId_51(), "");
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                break;
            case 55:
                id_55_value = valueItemNumber;
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(58, mathId_58(), "");
                setRelevantResultItem_value(61, mathId_61(), "");
                setRelevantResultItem_value(62, mathId_62(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                break;
            case 56:
                id_56_value = valueItemNumber;
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(58, mathId_58(), "");
                setRelevantResultItem_value(61, mathId_61(), "");
                setRelevantResultItem_value(62, mathId_62(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                break;
            case 59:
                id_59_position = spinnerPosition;
                setRelevantResultItem_value(60, mathId_60(), "");
                setRelevantResultItem_value(61, mathId_61(), "");
                setRelevantResultItem_value(62, mathId_62(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                break;
            case 66:
                id_66_value = valueItemNumber;
                setRelevantResultItem_value(69, mathId_69(), "");
                setRelevantResultItem_value(70, mathId_70(), "");
                setRelevantResultItem_value(74, mathId_74(), "");
                setRelevantResultItem_value(73, mathId_73(), "");
                setRelevantResultItem_value(75, mathId_75(), "");
                setRelevantResultItem_value(77, mathId_77(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                break;
            case 71:
                id_71_value = valueItemNumber;
                setRelevantResultItem_value(74, mathId_74(), "");
                setRelevantResultItem_value(75, mathId_75(), "");
                setRelevantResultItem_value(77, mathId_77(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                break;
            case 72:
                id_72_value = valueItemNumber;
                setRelevantResultItem_value(73, mathId_73(), "");
                setRelevantResultItem_value(74, mathId_74(), "");
                setRelevantResultItem_value(75, mathId_75(), "");
                setRelevantResultItem_value(77, mathId_77(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                setRelevantResultItem_value(80, mathId_80(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                break;

        }
    }

    private double getRelevantValueFromTable(int columnIndex) {
        int rowIndex = keysAList.indexOf(id_1_value);
        Log.d("checkMath", "getRelevantValueFromTable() -> columnIndex == " + columnIndex + "; rowIndex == " + rowIndex + "; id_1_value == " + id_1_value + "; keysAList.indexOf(id_1_value) == " + keysAList.indexOf(id_1_value));
        Log.d("checkMath", "getRelevantValueFromTable() -> valuesOfColumn_17_AList == " + valuesOfColumn_4_AList);
        switch (columnIndex){
            case 3: return valuesOfColumn_3_AList.get(rowIndex);
            case 4: return valuesOfColumn_4_AList.get(rowIndex);
            case 5: return valuesOfColumn_5_AList.get(rowIndex);
            case 6: return valuesOfColumn_6_AList.get(rowIndex);
            case 7: return valuesOfColumn_7_AList.get(rowIndex);
            case 9: return valuesOfColumn_9_AList.get(rowIndex);
            case 16: return valuesOfColumn_16_AList.get(rowIndex);
            case 17: return valuesOfColumn_17_AList.get(rowIndex);
            case 18: return valuesOfColumn_18_AList.get(rowIndex);
            case 19: return valuesOfColumn_19_AList.get(rowIndex);
            case 21: return valuesOfColumn_21_AList.get(rowIndex);
            case 24: return valuesOfColumn_24_AList.get(rowIndex);
            case 31: return valuesOfColumn_31_AList.get(rowIndex);
            case 32: return valuesOfColumn_32_AList.get(rowIndex);
            default: return 0;
        }
    }

    private double getRelevantValueCompareABCD(int comparePosition) {
        switch (comparePosition){
            case 0: return 0.21;
            case 1: return 0.34;
            case 2: return 0.49;
            case 3: return 0.76;
            default: return 0;
        }
    }
    private double getRelevantValueCompareValId_14() {
        switch ((int) id_14_value){
            case 195: return 0.0098;
            case 205: return 0.0101;
            case 215: return 0.0103;
            case 225: return 0.0105;
            case 235: return 0.0108;
            case 245: return 0.011;
            case 255: return 0.0112;
            case 265: return 0.0114;
            case 275: return 0.0117;
            case 325: return 0.0127;
            case 335: return 0.0129;
            case 345: return 0.0131;
            case 355: return 0.0132;
            default: return 0;
        }
    }

    private void setSeriesValuesALists() {
        keysAList = new ArrayList<>();
        keysAList.add(id_1001_value); keysAList.add(id_1101_value); keysAList.add(id_1201_value); keysAList.add(id_1301_value);
        keysAList.add(id_1401_value); keysAList.add(id_1501_value); keysAList.add(id_1601_value); keysAList.add(id_1701_value);
        keysAList.add(id_1801_value); keysAList.add(id_1901_value); keysAList.add(id_2001_value); keysAList.add(id_2101_value);
        keysAList.add(id_2201_value); keysAList.add(id_2301_value); keysAList.add(id_2401_value); keysAList.add(id_2501_value);
        keysAList.add(id_2601_value); keysAList.add(id_2701_value); keysAList.add(id_2801_value); keysAList.add(id_2901_value);
        keysAList.add(id_3001_value); keysAList.add(id_3101_value); keysAList.add(id_3201_value); keysAList.add(id_3301_value);
        Log.d("checkArrays", "setKeysValuesALists() -> keysAList == " + keysAList);
        valuesOfColumn_3_AList = new ArrayList<>();
        valuesOfColumn_3_AList.add(id_1003_value); valuesOfColumn_3_AList.add(id_1103_value); valuesOfColumn_3_AList.add(id_1203_value); valuesOfColumn_3_AList.add(id_1303_value);
        valuesOfColumn_3_AList.add(id_1403_value); valuesOfColumn_3_AList.add(id_1503_value); valuesOfColumn_3_AList.add(id_1603_value); valuesOfColumn_3_AList.add(id_1703_value);
        valuesOfColumn_3_AList.add(id_1803_value); valuesOfColumn_3_AList.add(id_1903_value); valuesOfColumn_3_AList.add(id_2003_value); valuesOfColumn_3_AList.add(id_2103_value);
        valuesOfColumn_3_AList.add(id_2203_value); valuesOfColumn_3_AList.add(id_2303_value); valuesOfColumn_3_AList.add(id_2403_value); valuesOfColumn_3_AList.add(id_2503_value);
        valuesOfColumn_3_AList.add(id_2603_value); valuesOfColumn_3_AList.add(id_2703_value); valuesOfColumn_3_AList.add(id_2803_value); valuesOfColumn_3_AList.add(id_2903_value);
        valuesOfColumn_3_AList.add(id_3003_value); valuesOfColumn_3_AList.add(id_3103_value); valuesOfColumn_3_AList.add(id_3203_value); valuesOfColumn_3_AList.add(id_3303_value);
        valuesOfColumn_4_AList = new ArrayList<>();
        valuesOfColumn_4_AList.add(id_1004_value); valuesOfColumn_4_AList.add(id_1104_value); valuesOfColumn_4_AList.add(id_1204_value); valuesOfColumn_4_AList.add(id_1304_value);
        valuesOfColumn_4_AList.add(id_1404_value); valuesOfColumn_4_AList.add(id_1504_value); valuesOfColumn_4_AList.add(id_1604_value); valuesOfColumn_4_AList.add(id_1704_value);
        valuesOfColumn_4_AList.add(id_1804_value); valuesOfColumn_4_AList.add(id_1904_value); valuesOfColumn_4_AList.add(id_2004_value); valuesOfColumn_4_AList.add(id_2104_value);
        valuesOfColumn_4_AList.add(id_2204_value); valuesOfColumn_4_AList.add(id_2304_value); valuesOfColumn_4_AList.add(id_2404_value); valuesOfColumn_4_AList.add(id_2504_value);
        valuesOfColumn_4_AList.add(id_2604_value); valuesOfColumn_4_AList.add(id_2704_value); valuesOfColumn_4_AList.add(id_2804_value); valuesOfColumn_4_AList.add(id_2904_value);
        valuesOfColumn_4_AList.add(id_3004_value); valuesOfColumn_4_AList.add(id_3103_value); valuesOfColumn_4_AList.add(id_3203_value); valuesOfColumn_4_AList.add(id_3303_value);
        valuesOfColumn_5_AList = new ArrayList<>();
        valuesOfColumn_5_AList.add(id_1005_value); valuesOfColumn_5_AList.add(id_1105_value); valuesOfColumn_5_AList.add(id_1205_value); valuesOfColumn_5_AList.add(id_1305_value);
        valuesOfColumn_5_AList.add(id_1405_value); valuesOfColumn_5_AList.add(id_1505_value); valuesOfColumn_5_AList.add(id_1605_value); valuesOfColumn_5_AList.add(id_1705_value);
        valuesOfColumn_5_AList.add(id_1805_value); valuesOfColumn_5_AList.add(id_1905_value); valuesOfColumn_5_AList.add(id_2005_value); valuesOfColumn_5_AList.add(id_2105_value);
        valuesOfColumn_5_AList.add(id_2205_value); valuesOfColumn_5_AList.add(id_2305_value); valuesOfColumn_5_AList.add(id_2405_value); valuesOfColumn_5_AList.add(id_2505_value);
        valuesOfColumn_5_AList.add(id_2605_value); valuesOfColumn_5_AList.add(id_2705_value); valuesOfColumn_5_AList.add(id_2805_value); valuesOfColumn_5_AList.add(id_2905_value);
        valuesOfColumn_5_AList.add(id_3005_value); valuesOfColumn_5_AList.add(id_3103_value); valuesOfColumn_5_AList.add(id_3203_value); valuesOfColumn_5_AList.add(id_3303_value);
        valuesOfColumn_6_AList = new ArrayList<>();
        valuesOfColumn_6_AList.add(id_1006_value); valuesOfColumn_6_AList.add(id_1106_value); valuesOfColumn_6_AList.add(id_1206_value); valuesOfColumn_6_AList.add(id_1306_value);
        valuesOfColumn_6_AList.add(id_1406_value); valuesOfColumn_6_AList.add(id_1506_value); valuesOfColumn_6_AList.add(id_1606_value); valuesOfColumn_6_AList.add(id_1706_value);
        valuesOfColumn_6_AList.add(id_1806_value); valuesOfColumn_6_AList.add(id_1906_value); valuesOfColumn_6_AList.add(id_2006_value); valuesOfColumn_6_AList.add(id_2106_value);
        valuesOfColumn_6_AList.add(id_2206_value); valuesOfColumn_6_AList.add(id_2306_value); valuesOfColumn_6_AList.add(id_2406_value); valuesOfColumn_6_AList.add(id_2506_value);
        valuesOfColumn_6_AList.add(id_2606_value); valuesOfColumn_6_AList.add(id_2706_value); valuesOfColumn_6_AList.add(id_2806_value); valuesOfColumn_6_AList.add(id_2906_value);
        valuesOfColumn_6_AList.add(id_3006_value); valuesOfColumn_6_AList.add(id_3103_value); valuesOfColumn_6_AList.add(id_3203_value); valuesOfColumn_6_AList.add(id_3303_value);
        valuesOfColumn_7_AList = new ArrayList<>();
        valuesOfColumn_7_AList.add(id_1007_value); valuesOfColumn_7_AList.add(id_1107_value); valuesOfColumn_7_AList.add(id_1207_value); valuesOfColumn_7_AList.add(id_1307_value);
        valuesOfColumn_7_AList.add(id_1407_value); valuesOfColumn_7_AList.add(id_1507_value); valuesOfColumn_7_AList.add(id_1607_value); valuesOfColumn_7_AList.add(id_1707_value);
        valuesOfColumn_7_AList.add(id_1807_value); valuesOfColumn_7_AList.add(id_1907_value); valuesOfColumn_7_AList.add(id_2007_value); valuesOfColumn_7_AList.add(id_2107_value);
        valuesOfColumn_7_AList.add(id_2207_value); valuesOfColumn_7_AList.add(id_2307_value); valuesOfColumn_7_AList.add(id_2407_value); valuesOfColumn_7_AList.add(id_2507_value);
        valuesOfColumn_7_AList.add(id_2607_value); valuesOfColumn_7_AList.add(id_2707_value); valuesOfColumn_7_AList.add(id_2807_value); valuesOfColumn_7_AList.add(id_2907_value);
        valuesOfColumn_7_AList.add(id_3007_value); valuesOfColumn_7_AList.add(id_3103_value); valuesOfColumn_7_AList.add(id_3203_value); valuesOfColumn_7_AList.add(id_3303_value);
        valuesOfColumn_9_AList = new ArrayList<>();
        valuesOfColumn_9_AList.add(id_1009_value); valuesOfColumn_9_AList.add(id_1109_value); valuesOfColumn_9_AList.add(id_1209_value); valuesOfColumn_9_AList.add(id_1309_value);
        valuesOfColumn_9_AList.add(id_1409_value); valuesOfColumn_9_AList.add(id_1509_value); valuesOfColumn_9_AList.add(id_1609_value); valuesOfColumn_9_AList.add(id_1709_value);
        valuesOfColumn_9_AList.add(id_1809_value); valuesOfColumn_9_AList.add(id_1909_value); valuesOfColumn_9_AList.add(id_2009_value); valuesOfColumn_9_AList.add(id_2109_value);
        valuesOfColumn_9_AList.add(id_2209_value); valuesOfColumn_9_AList.add(id_2309_value); valuesOfColumn_9_AList.add(id_2409_value); valuesOfColumn_9_AList.add(id_2509_value);
        valuesOfColumn_9_AList.add(id_2609_value); valuesOfColumn_9_AList.add(id_2709_value); valuesOfColumn_9_AList.add(id_2809_value); valuesOfColumn_9_AList.add(id_2909_value);
        valuesOfColumn_9_AList.add(id_3009_value); valuesOfColumn_9_AList.add(id_3103_value); valuesOfColumn_9_AList.add(id_3203_value); valuesOfColumn_9_AList.add(id_3303_value);
        valuesOfColumn_16_AList = new ArrayList<>();
        valuesOfColumn_16_AList.add(id_1016_value); valuesOfColumn_16_AList.add(id_1116_value); valuesOfColumn_16_AList.add(id_1216_value); valuesOfColumn_16_AList.add(id_1316_value);
        valuesOfColumn_16_AList.add(id_1416_value); valuesOfColumn_16_AList.add(id_1516_value); valuesOfColumn_16_AList.add(id_1616_value); valuesOfColumn_16_AList.add(id_1716_value);
        valuesOfColumn_16_AList.add(id_1816_value); valuesOfColumn_16_AList.add(id_1916_value); valuesOfColumn_16_AList.add(id_2016_value); valuesOfColumn_16_AList.add(id_2116_value);
        valuesOfColumn_16_AList.add(id_2216_value); valuesOfColumn_16_AList.add(id_2316_value); valuesOfColumn_16_AList.add(id_2416_value); valuesOfColumn_16_AList.add(id_2516_value);
        valuesOfColumn_16_AList.add(id_2616_value); valuesOfColumn_16_AList.add(id_2716_value); valuesOfColumn_16_AList.add(id_2816_value); valuesOfColumn_16_AList.add(id_2916_value);
        valuesOfColumn_16_AList.add(id_3016_value); valuesOfColumn_16_AList.add(id_3103_value); valuesOfColumn_16_AList.add(id_3203_value); valuesOfColumn_16_AList.add(id_3303_value);
        valuesOfColumn_17_AList = new ArrayList<>();
        valuesOfColumn_17_AList.add(id_1017_value); valuesOfColumn_17_AList.add(id_1117_value); valuesOfColumn_17_AList.add(id_1217_value); valuesOfColumn_17_AList.add(id_1317_value);
        valuesOfColumn_17_AList.add(id_1417_value); valuesOfColumn_17_AList.add(id_1517_value); valuesOfColumn_17_AList.add(id_1617_value); valuesOfColumn_17_AList.add(id_1717_value);
        valuesOfColumn_17_AList.add(id_1817_value); valuesOfColumn_17_AList.add(id_1917_value); valuesOfColumn_17_AList.add(id_2017_value); valuesOfColumn_17_AList.add(id_2117_value);
        valuesOfColumn_17_AList.add(id_2217_value); valuesOfColumn_17_AList.add(id_2317_value); valuesOfColumn_17_AList.add(id_2417_value); valuesOfColumn_17_AList.add(id_2517_value);
        valuesOfColumn_17_AList.add(id_2617_value); valuesOfColumn_17_AList.add(id_2717_value); valuesOfColumn_17_AList.add(id_2817_value); valuesOfColumn_17_AList.add(id_2917_value);
        valuesOfColumn_17_AList.add(id_3017_value); valuesOfColumn_17_AList.add(id_3103_value); valuesOfColumn_17_AList.add(id_3203_value); valuesOfColumn_17_AList.add(id_3303_value);
        valuesOfColumn_18_AList = new ArrayList<>();
        valuesOfColumn_18_AList.add(id_1018_value); valuesOfColumn_18_AList.add(id_1118_value); valuesOfColumn_18_AList.add(id_1218_value); valuesOfColumn_18_AList.add(id_1318_value);
        valuesOfColumn_18_AList.add(id_1418_value); valuesOfColumn_18_AList.add(id_1518_value); valuesOfColumn_18_AList.add(id_1618_value); valuesOfColumn_18_AList.add(id_1718_value);
        valuesOfColumn_18_AList.add(id_1818_value); valuesOfColumn_18_AList.add(id_1918_value); valuesOfColumn_18_AList.add(id_2018_value); valuesOfColumn_18_AList.add(id_2118_value);
        valuesOfColumn_18_AList.add(id_2218_value); valuesOfColumn_18_AList.add(id_2318_value); valuesOfColumn_18_AList.add(id_2418_value); valuesOfColumn_18_AList.add(id_2518_value);
        valuesOfColumn_18_AList.add(id_2618_value); valuesOfColumn_18_AList.add(id_2718_value); valuesOfColumn_18_AList.add(id_2818_value); valuesOfColumn_18_AList.add(id_2918_value);
        valuesOfColumn_18_AList.add(id_3018_value); valuesOfColumn_18_AList.add(id_3103_value); valuesOfColumn_18_AList.add(id_3203_value); valuesOfColumn_18_AList.add(id_3303_value);
        valuesOfColumn_19_AList = new ArrayList<>();
        valuesOfColumn_19_AList.add(id_1019_value); valuesOfColumn_19_AList.add(id_1119_value); valuesOfColumn_19_AList.add(id_1219_value); valuesOfColumn_19_AList.add(id_1319_value);
        valuesOfColumn_19_AList.add(id_1419_value); valuesOfColumn_19_AList.add(id_1519_value); valuesOfColumn_19_AList.add(id_1619_value); valuesOfColumn_19_AList.add(id_1719_value);
        valuesOfColumn_19_AList.add(id_1819_value); valuesOfColumn_19_AList.add(id_1919_value); valuesOfColumn_19_AList.add(id_2019_value); valuesOfColumn_19_AList.add(id_2119_value);
        valuesOfColumn_19_AList.add(id_2219_value); valuesOfColumn_19_AList.add(id_2319_value); valuesOfColumn_19_AList.add(id_2419_value); valuesOfColumn_19_AList.add(id_2519_value);
        valuesOfColumn_19_AList.add(id_2619_value); valuesOfColumn_19_AList.add(id_2719_value); valuesOfColumn_19_AList.add(id_2819_value); valuesOfColumn_19_AList.add(id_2919_value);
        valuesOfColumn_19_AList.add(id_3019_value); valuesOfColumn_19_AList.add(id_3103_value); valuesOfColumn_19_AList.add(id_3203_value); valuesOfColumn_19_AList.add(id_3303_value);
        valuesOfColumn_21_AList = new ArrayList<>();
        valuesOfColumn_21_AList.add(id_1021_value); valuesOfColumn_21_AList.add(id_1121_value); valuesOfColumn_21_AList.add(id_1221_value); valuesOfColumn_21_AList.add(id_1321_value);
        valuesOfColumn_21_AList.add(id_1421_value); valuesOfColumn_21_AList.add(id_1521_value); valuesOfColumn_21_AList.add(id_1621_value); valuesOfColumn_21_AList.add(id_1721_value);
        valuesOfColumn_21_AList.add(id_1821_value); valuesOfColumn_21_AList.add(id_1921_value); valuesOfColumn_21_AList.add(id_2021_value); valuesOfColumn_21_AList.add(id_2121_value);
        valuesOfColumn_21_AList.add(id_2221_value); valuesOfColumn_21_AList.add(id_2321_value); valuesOfColumn_21_AList.add(id_2421_value); valuesOfColumn_21_AList.add(id_2521_value);
        valuesOfColumn_21_AList.add(id_2621_value); valuesOfColumn_21_AList.add(id_2721_value); valuesOfColumn_21_AList.add(id_2821_value); valuesOfColumn_21_AList.add(id_2921_value);
        valuesOfColumn_21_AList.add(id_3021_value); valuesOfColumn_21_AList.add(id_3103_value); valuesOfColumn_21_AList.add(id_3203_value); valuesOfColumn_21_AList.add(id_3303_value);
        valuesOfColumn_24_AList = new ArrayList<>();
        valuesOfColumn_24_AList.add(id_1024_value); valuesOfColumn_24_AList.add(id_1124_value); valuesOfColumn_24_AList.add(id_1224_value); valuesOfColumn_24_AList.add(id_1324_value);
        valuesOfColumn_24_AList.add(id_1424_value); valuesOfColumn_24_AList.add(id_1524_value); valuesOfColumn_24_AList.add(id_1624_value); valuesOfColumn_24_AList.add(id_1724_value);
        valuesOfColumn_24_AList.add(id_1824_value); valuesOfColumn_24_AList.add(id_1924_value); valuesOfColumn_24_AList.add(id_2024_value); valuesOfColumn_24_AList.add(id_2124_value);
        valuesOfColumn_24_AList.add(id_2224_value); valuesOfColumn_24_AList.add(id_2324_value); valuesOfColumn_24_AList.add(id_2424_value); valuesOfColumn_24_AList.add(id_2524_value);
        valuesOfColumn_24_AList.add(id_2624_value); valuesOfColumn_24_AList.add(id_2724_value); valuesOfColumn_24_AList.add(id_2824_value); valuesOfColumn_24_AList.add(id_2924_value);
        valuesOfColumn_24_AList.add(id_3024_value); valuesOfColumn_24_AList.add(id_3103_value); valuesOfColumn_24_AList.add(id_3203_value); valuesOfColumn_24_AList.add(id_3303_value);
        valuesOfColumn_31_AList = new ArrayList<>();
        valuesOfColumn_31_AList.add(id_1031_value); valuesOfColumn_31_AList.add(id_1131_value); valuesOfColumn_31_AList.add(id_1231_value); valuesOfColumn_31_AList.add(id_1331_value);
        valuesOfColumn_31_AList.add(id_1431_value); valuesOfColumn_31_AList.add(id_1531_value); valuesOfColumn_31_AList.add(id_1631_value); valuesOfColumn_31_AList.add(id_1731_value);
        valuesOfColumn_31_AList.add(id_1831_value); valuesOfColumn_31_AList.add(id_1931_value); valuesOfColumn_31_AList.add(id_2031_value); valuesOfColumn_31_AList.add(id_2131_value);
        valuesOfColumn_31_AList.add(id_2231_value); valuesOfColumn_31_AList.add(id_2331_value); valuesOfColumn_31_AList.add(id_2431_value); valuesOfColumn_31_AList.add(id_2531_value);
        valuesOfColumn_31_AList.add(id_2631_value); valuesOfColumn_31_AList.add(id_2731_value); valuesOfColumn_31_AList.add(id_2831_value); valuesOfColumn_31_AList.add(id_2931_value);
        valuesOfColumn_31_AList.add(id_3031_value); valuesOfColumn_31_AList.add(id_3103_value); valuesOfColumn_31_AList.add(id_3203_value); valuesOfColumn_31_AList.add(id_3303_value);
        valuesOfColumn_32_AList = new ArrayList<>();
        valuesOfColumn_32_AList.add(id_1032_value); valuesOfColumn_32_AList.add(id_1132_value); valuesOfColumn_32_AList.add(id_1232_value); valuesOfColumn_32_AList.add(id_1332_value);
        valuesOfColumn_32_AList.add(id_1432_value); valuesOfColumn_32_AList.add(id_1532_value); valuesOfColumn_32_AList.add(id_1632_value); valuesOfColumn_32_AList.add(id_1732_value);
        valuesOfColumn_32_AList.add(id_1832_value); valuesOfColumn_32_AList.add(id_1932_value); valuesOfColumn_32_AList.add(id_2032_value); valuesOfColumn_32_AList.add(id_2132_value);
        valuesOfColumn_32_AList.add(id_2232_value); valuesOfColumn_32_AList.add(id_2332_value); valuesOfColumn_32_AList.add(id_2432_value); valuesOfColumn_32_AList.add(id_2532_value);
        valuesOfColumn_32_AList.add(id_2632_value); valuesOfColumn_32_AList.add(id_2732_value); valuesOfColumn_32_AList.add(id_2832_value); valuesOfColumn_32_AList.add(id_2932_value);
        valuesOfColumn_32_AList.add(id_3032_value); valuesOfColumn_32_AList.add(id_3103_value); valuesOfColumn_32_AList.add(id_3203_value); valuesOfColumn_32_AList.add(id_3303_value);
    }

    public void tonOrKnBtnClicked() {
        Log.d("checkActionBtnClicked", "actionBtnClicked()");
        setRelevantResultItem_value(24, mathId_24(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(25, mathId_25(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(26, mathId_26(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(28, mathId_28(), getRelevantSecondMeasuringUnit(2));
        setRelevantResultItem_value(29, mathId_29(), getRelevantSecondMeasuringUnit(2));
        setRelevantResultItem_value(31, mathId_31(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(33, mathId_33(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(35, mathId_35(), getRelevantSecondMeasuringUnit(2));
        setRelevantResultItem_value(36, mathId_36(), getRelevantSecondMeasuringUnit(2));
        setRelevantResultItem_value(38, mathId_38(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(39, mathId_39(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(40, mathId_40(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(41, mathId_41(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(51, mathId_51(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(52, mathId_52(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(63, mathId_63(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(64, mathId_64(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(67, mathId_67(), getRelevantSecondMeasuringUnit(3));
        setRelevantResultItem_value(68, mathId_68(), getRelevantSecondMeasuringUnit(4));
        setRelevantResultItem_value(69, mathId_69(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(70, mathId_70(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(73, mathId_73(), getRelevantSecondMeasuringUnit(2));
        setRelevantResultItem_value(75, mathId_75(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(76, mathId_76(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(79, mathId_79(), getRelevantSecondMeasuringUnit(0));
    }
}
