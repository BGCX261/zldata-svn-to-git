package com.zl.processing.dataVis;

/**
 * ����
 * 
 * @author lyc557@163.com 2013-2-21����11:10:36
 */
public class Data {
	float[][] d;
	int n;
	float maxy;
	float maxx;
	int m;// (�ǲ��Ƕ�ά�ı��)

	Data(float[][] idata) {// ���캯��
		d = idata;
		n = d.length;
		maxx = d[n - 1][0];
		maxy = d[0][1];
		for (int k = 0; k < n; k++) {
			if (d[k][1] > maxy) {
				maxy = d[k][1];
			}
		}
	}
	
}