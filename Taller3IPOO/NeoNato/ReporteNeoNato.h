#ifndef REPORTE_NEONATO_H
#define REPORTE_NEONATO_H

#include <qstring.h>
#include <qdatetime.h>


class ReporteNeoNato
{

	private:
	QDate fecha;
	 
	public:
	ReporteNeoNato();
	virtual  ~ReporteNeoNato();
	
	virtual QString armarReporte(const QString & nombresPadre,
		 const QString & apellidoPadre,	 
		 const QString & nombresMadre,
		 const QString & apellidoMadre,	 
		 const QString & nombresNeoNato,
		 const QString & genero,
		const double &  alturaCM,
		const double &  pesoLibras);
};

#endif