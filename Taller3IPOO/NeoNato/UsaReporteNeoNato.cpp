#include "UsaReporteNeoNato.h"


UsaReporteNeoNato::UsaReporteNeoNato(QWidget *ptr_QWidgetPadre,const char *ptr_NombreQWidget)
:QWidget(ptr_QWidgetPadre,ptr_NombreQWidget) {
	inicializarControles();
	acomodarControles();
	conectarControles();
}

UsaReporteNeoNato::~UsaReporteNeoNato() {
	
}

void UsaReporteNeoNato::inicializarControles() {
	ptrMiReporte = new ReporteNeoNato();
	ptrGrilla = new QGridLayout(this,11,3,10);
	ptrBoton1 = new QPushButton("Generar Reporte", this);
	ptrBoton2 = new QPushButton("Salir", this);
	ptrRestaurar = new QPushButton("Restaurar",this);
	ptrTextos[0] = new QLineEdit(this);
	ptrLabels[0] = new QLabel("Nombres del Padre:", this, 0);
	ptrTextos[1] = new QLineEdit(this);
	ptrLabels[1] = new QLabel("Apellidos del Padre:", this, 0);
	ptrTextos[2] = new QLineEdit(this);
	ptrLabels[2] = new QLabel("Nombres de la Madre:", this, 0);
	ptrTextos[3] = new QLineEdit(this);
	ptrLabels[3] = new QLabel("Apellidos de la Madre:", this, 0);
	ptrTextos[4] = new QLineEdit(this);
	ptrLabels[4] = new QLabel("Nombre del Beb‚:", this, 0);
	ptrTextos[5] = new QLineEdit(this);
	ptrLabels[5] = new QLabel("Genero del Beb‚:", this, 0);
	ptrTextos[6] = new QLineEdit(this);
	ptrLabels[6] = new QLabel("Altura del Beb‚(Cms):", this, 0);
	ptrTextos[7] = new QLineEdit(this);
	ptrLabels[7] = new QLabel("Peso del Beb‚(Lbs):", this, 0);
	ptrReporte = new QTextEdit(this);
	ptrReporte->setReadOnly(true);
}

void UsaReporteNeoNato::acomodarControles() {
	for(int i=0;i<numeroDatos;i++) {
		ptrGrilla->addWidget(ptrLabels[i], i+1,1);
		ptrGrilla->addMultiCellWidget(ptrTextos[i],i+1,i+1,2,3,0);
	}
	ptrGrilla->addMultiCellWidget(ptrReporte,9,9,1,3,0);
	ptrGrilla->addWidget(ptrBoton1, 10,1);
	ptrGrilla->addWidget(ptrBoton2, 10,3);
	ptrGrilla->addWidget(ptrRestaurar,10,2);
}

void UsaReporteNeoNato::conectarControles() {
	connect(ptrBoton2,SIGNAL(clicked()),qApp,SLOT(quit()));
	connect(ptrBoton1,SIGNAL(clicked()),this,SLOT(generarReporte()));
	connect(ptrRestaurar,SIGNAL(clicked()),this,SLOT(restaurar()));
}

void UsaReporteNeoNato::generarReporte() {
	bool novacio = capturarDatos();
	if(novacio) {
		ptrReporte->setText(ptrMiReporte->armarReporte(NombresPadre, ApellidosPadre, NombresMadre, ApellidosMadre, NombreBebe, Genero, Altura.toDouble(), Peso.toDouble()));
	}
	else {
		ptrReporte->setText("Falta(n) campo(s) por rellenar");
	}
}

void UsaReporteNeoNato::restaurar() {
	for(int i=0;i<numeroDatos;i++) {
		ptrTextos[i]->clear();
	}
	ptrReporte->setText("");
}

bool UsaReporteNeoNato::capturarDatos() {
	NombresPadre = QString(ptrTextos[0]->displayText());
	ApellidosPadre = QString(ptrTextos[1]->displayText());
	NombresMadre = QString(ptrTextos[2]->displayText());
	ApellidosMadre = QString(ptrTextos[3]->displayText());
	NombreBebe = QString(ptrTextos[4]->displayText());
	Genero = QString(ptrTextos[5]->displayText());
	Altura = QString(ptrTextos[6]->displayText());
	Peso = QString(ptrTextos[7]->displayText());
	if(!(NombresPadre.isEmpty()) && !(ApellidosPadre.isEmpty()) && !(NombresMadre.isEmpty()) && !(ApellidosMadre.isEmpty()) && !(NombreBebe.isEmpty()) && !(Genero.isEmpty()) && !(Altura.isEmpty()) && !(Peso.isEmpty())) {
		return true;
	}
	return false;
}

int main(int argc, char **argv) {
	QApplication aplicacion(argc,argv);
	QApplication ::setFont(QFont( "Times", 12, QFont::Bold ), true);
	UsaReporteNeoNato miReporte(0,"ReporteNeoNato");
	aplicacion.setMainWidget(&miReporte);
	miReporte.show();
	return aplicacion.exec();
}
