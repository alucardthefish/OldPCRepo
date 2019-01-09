#ifndef "USAFILTROSCOLOR_H"
#define "USAFILTROSCOLOR_H"


class UsaFiltrosColor
{
	private:
	
	FiltrosColor * ptrFiltros;
	Img * imgInput1;
	Img * imgInput2;
	img * imgOutput;
	
	string cadIn1,cadIn2,cadOut;
	
	
	public:
           
    UsaFiltrosColor ();
    ~UsaFiltroscolor ();
    void interactuar ();
    
    
