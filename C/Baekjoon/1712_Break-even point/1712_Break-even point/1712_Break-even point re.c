#include <stdio.h>
//���ͺб��� ���

int main() {
	long a, b, c, sum;//a �������, b �������, c �Ǹź�� bs, cs �߰����
	scanf("%d %d %d", &a, &b, &c);
	if (c - b <= 0) { //���ͺб����� ������ -1 ��ȯ
		printf("%d", -1);
		return 0;
	}
	else {
		sum = a / (c - b) + 1; //cx - (a + bx) > 0 �� �����ؾ� ��
		printf("%d", sum);
	}
	return 0;
}
/*	���� ������ �Ѿ�ϱ� �ǵ��� �������� Ǯ��
	bs = b; //�ʱ�ȭ
	cs = c;
	if (b > c) //���ͺб����� ������ -1 ��ȯ
		printf("%d", -1);
	else {
		for (i = 1; ; i++) {
			if ((a + bs) / cs < 1) { //�Ǹź���� �� Ŀ���� ���� ����
				printf("%d", i);
				break;
			}
			else { //�������� �Ǹź�� �߰�
				bs += b;
				cs += c;
			}
		}
	}
	return 0;*/
}