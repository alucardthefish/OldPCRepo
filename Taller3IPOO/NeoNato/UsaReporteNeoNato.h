#ifndef UsaReporteNeoNato_H
#define UsaReporteNeoNato_H

#include "ReporteNeoNato.h"

#include <iostream>
#include <qapplication.h>
#include <qpushbutton.h>
#include <qfont.h>
#include <qwidget.h>
#include <qlayout.h>
#include <qstring.h>
#include <qmessagebox.h>
#include <qinputdialog.h>
#include <qtooltip.h>
#include <qlineedit.h>
#include <qlabel.h>
#include <qtextedit.h>


//mala pr ctica de programaci¢n :( Corregir!!
#define numeroDatos 8

class UsaReporteNeoNato : public QWidget {
	//macro requerida en el caso de usar signals y slots,osea en la GUIs 
	Q_OBJECT
	private:
		ReporteNeoNato *ptrMiReporte;
		QGridLayout *ptrGrilla;
		QPushButton *ptrBoton1;
		QPushButton *ptrBoton2;
		QPushButton *ptrRestaurar;
		QLineEdit *ptrTextos[numeroDatos];
		QLabel *ptrLabels[numeroDatos];
		QTextEdit *ptrReporte;
		
		//nombres de variables que no se ajustan al "estandar"
		QString NombresPadre;
		QString ApellidosPadre;
		QString NombresMadre;
		QString ApellidosMadre;
		QString NombreBebe;
		QString Genero;
		QString Altura;
		QString Peso;
		
	public:
		UsaReporteNeoNato(QWidget *ptr_QWidgetPadre=0,const char *ptr_NombreQWidget=0);
		virtual ~UsaReporteNeoNato();
		virtual bool capturarDatos();
		virtual void inicializarControles();
		virtual void acomodarControles();
		virtual void conectarControles();
		
	public slots:
		virtual void generarReporte();
		virtual void restaurar();
};

#endif
