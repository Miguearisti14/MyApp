package com.upb.myrestaurant;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ProductoActivity extends ListActivity {

    public class Producto {
        private String nombreProducto;
        private String ingredientesProducto;
        private String precioProducto;
        private Integer imagenProducto;
    }

    private MyAdapter adaptador = null;
    private static ArrayList <Producto> arregloProductos = new ArrayList<Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
        adaptador = new MyAdapter(this);
        setListAdapter(adaptador);


        //EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_producto);
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //  Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //return insets;
        //});
    }

    private void setData(){
        arregloProductos.clear();


        //Entrada 1
        ProductoActivity.Producto ProductoActual1 = new ProductoActivity.Producto();
        ProductoActual1.nombreProducto = this.getResources().getString(R.string.Entrada1);
        ProductoActual1.ingredientesProducto = this.getResources().getString(R.string.ING_Entrada1);
        ProductoActual1.precioProducto = this.getResources().getString(R.string.PRECIO_Entrada1);
        ProductoActual1.imagenProducto = R.drawable.brus;
        arregloProductos.add(ProductoActual1);

        //Entrada 2
        ProductoActivity.Producto ProductoActual2 = new ProductoActivity.Producto();
        ProductoActual2.nombreProducto = this.getResources().getString(R.string.Entrada2);
        ProductoActual2.ingredientesProducto = this.getResources().getString(R.string.ING_Entrada2);
        ProductoActual2.precioProducto = this.getResources().getString(R.string.PRECIO_Entrada2);
        ProductoActual2.imagenProducto = R.drawable.brus;
        arregloProductos.add(ProductoActual2);

        //Entrada 3
        ProductoActivity.Producto ProductoActual3 = new ProductoActivity.Producto();
        ProductoActual3.nombreProducto = this.getResources().getString(R.string.Entrada3);
        ProductoActual3.ingredientesProducto = this.getResources().getString(R.string.ING_Entrada3);
        ProductoActual3.precioProducto = this.getResources().getString(R.string.PRECIO_Entrada3);
        ProductoActual3.imagenProducto = R.drawable.brus;
        arregloProductos.add(ProductoActual3);

    }

    public static class MyAdapter extends BaseAdapter{

        private Context myContexto;

        public MyAdapter (Context c){
            myContexto = c;
        }

        @Override
        public int getCount(){
            return arregloProductos.size();
        }

        @Override
        public Object getItem(int arg){
            return arregloProductos.get(arg);
        }

        @Override
        public long getItemId(int arg){
            return 0;
        }

        @Override
        public View getView(int position, View vista, ViewGroup arg2){

            View view = null;

            if (vista == null){
                LayoutInflater inflater = (LayoutInflater) myContexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_producto, null);
            }
            else {
                view = vista;
            }

            ImageView imgProducto = (ImageView) view.findViewById(R.id.imageViewProducto);
            imgProducto.setImageDrawable(myContexto.getResources().getDrawable(arregloProductos.get(position).imagenProducto));

            TextView nombrePorducto = (TextView) view.findViewById(R.id.textViewNombreProducto);
            nombrePorducto.setText(arregloProductos.get(position).nombreProducto);

            TextView ingredientesPorducto = (TextView) view.findViewById(R.id.textViewIngredientes);
            ingredientesPorducto.setText(arregloProductos.get(position).ingredientesProducto);

            TextView precioPorducto = (TextView) view.findViewById(R.id.textViewPrecio);
            precioPorducto.setText(arregloProductos.get(position).precioProducto);


            return view;
  }

}
}