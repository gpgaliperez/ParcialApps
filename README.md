# ParcialApps

En El onCreate de Mapa activity era

        Intent in= getIntent();
        Bundle b = in.getExtras();
        if(b!=null)
        {
            lugares = (ArrayList<String>) b.get("lugares");

        }
