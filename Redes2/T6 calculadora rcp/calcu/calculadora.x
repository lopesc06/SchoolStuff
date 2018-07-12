struct entrada
{
	int arg1;
	int arg2;
};

program CAL
{
	version UNO
	{
		int suma(entrada) = 1;
		int resta(entrada) = 2;
		int multi(entrada) = 3;
		int div(entrada) = 4;
	} = 1;
} = 0x30000001;
