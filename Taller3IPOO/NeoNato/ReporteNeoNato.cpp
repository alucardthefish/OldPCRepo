#include "ReporteNeoNato.h"


ReporteNeoNato::ReporteNeoNato( )
{
	fecha = QDate::currentDate();
}

ReporteNeoNato::~ReporteNeoNato( )
{
	
}

QString ReporteNeoNato::armarReporte(const QString & nombresPadre,
			const QString & apellidoPadre,
			const QString & nombresMadre,
			const QString & apellidoMadre,	 
			const QString & nombresNeoNato,
			const QString & genero,
			const double &  alturaCM,
			const double & pesoLibras)
{
	QString resultado("");
	resultado="El d¡a "+fecha.toString("dd MMM yyyy")+" se presentaron:"+"\n";
	resultado+=apellidoPadre+" "+nombresPadre+" y "+apellidoMadre+" "+nombresMadre+"\n";
	resultado+="A reportar el nacimiento de:\n";
	resultado+="\t"+nombresNeoNato+" "+apellidoPadre+" "+apellidoMadre+"\n";
	resultado+="Genero: "+genero+"\n";
	resultado+="Altura (cm): "+QString::number(alturaCM)+"\n";
	resultado+="Peso (lb):  "+QString::number(pesoLibras)+"\n";
	return QString(resultado);
}

