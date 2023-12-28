package main.melle.zonacasse;

import java.util.List;

public interface ZonaCasse {

	int getNCasse();
	
	int getLunghezzaCoda(Cassa cassa);
	
	Cassa getCassaConCodaPiuBreve();
}
