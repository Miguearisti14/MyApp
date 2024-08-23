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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class PlatosActivity extends ListActivity {

    public class Producto {
        private String nombreProducto;
        private String ingredientesProducto;
        private String precioProducto;
        private Integer imagenProducto;
    }

    private PlatosActivity.MyAdapter adaptador = null;
    private static ArrayList<PlatosActivity.Producto> arregloProductos = new ArrayList<PlatosActivity.Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
        adaptador = new PlatosActivity.MyAdapter(this);
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


        //Plato 1
        PlatosActivity.Producto PlatoActual1 = new PlatosActivity.Producto();
        PlatoActual1.nombreProducto = this.getResources().getString(R.string.Plato1);
        PlatoActual1.ingredientesProducto = this.getResources().getString(R.string.ING_Plato1);
        PlatoActual1.precioProducto = this.getResources().getString(R.string.PRECIO_Plato1);
        PlatoActual1.imagenProducto = R.drawable.pizza;
        arregloProductos.add(PlatoActual1);

        //Plato 2
        PlatosActivity.Producto PlatoActual2 = new PlatosActivity.Producto();
        PlatoActual2.nombreProducto = this.getResources().getString(R.string.Plato2);
        PlatoActual2.ingredientesProducto = this.getResources().getString(R.string.ING_Plato2);
        PlatoActual2.precioProducto = this.getResources().getString(R.string.PRECIO_Plato2);
        PlatoActual2.imagenProducto = R.drawable.pasta;
        arregloProductos.add(PlatoActual2);

        //Plato 3
        PlatosActivity.Producto PlatoActual3 = new PlatosActivity.Producto();
        PlatoActual3.nombreProducto = this.getResources().getString(R.string.Plato3);
        PlatoActual3.ingredientesProducto = this.getResources().getString(R.string.ING_Plato2);
        PlatoActual3.precioProducto = this.getResources().getString(R.string.PRECIO_Plato3);
        PlatoActual3.imagenProducto = R.drawable.lasana;
        arregloProductos.add(PlatoActual3);

    }

    public static class MyAdapter extends BaseAdapter {

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

            TextView precioPorducto = (TextView) view.findViewById(R.id.textViewPrecioProducto);
            precioPorducto.setText(arregloProductos.get(position).precioProducto);


            return view;
        }

    }
}