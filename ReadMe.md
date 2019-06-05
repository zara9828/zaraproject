# first error
Android resource linking failed
C:\Users\saran\StudioProjects\zaraproject\app\build\intermediates\incremental\mergeDebugResources\merged.dir\values\values.xml:645: error: resource color/colorPrimary (aka com.example.alzaraapriliani.zaraproject:color/colorPrimary) not found.
C:\Users\saran\StudioProjects\zaraproject\app\build\intermediates\incremental\mergeDebugResources\merged.dir\values\values.xml:646: error: resource color/colorPrimaryDark (aka com.example.alzaraapriliani.zaraproject:color/colorPrimaryDark) not found.
C:\Users\saran\StudioProjects\zaraproject\app\build\intermediates\incremental\mergeDebugResources\merged.dir\values\values.xml:647: error: resource color/colorAccent (aka com.example.alzaraapriliani.zaraproject:color/colorAccent) not found.
error: failed linking references.

- create colors file
- paht = zaraproject\app\src\main\res\values\colors.xml

colors.xml
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#FFE100</color>
    <color name="colorPrimaryDark">#88000000</color>
    <color name="colorAccent">#FF4081</color>
</resources>
```

# second error
Android resource linking failed
C:\Users\saran\StudioProjects\zaraproject\app\src\main\res\drawable\shape_white.xml:3: error: resource color/colorBasic (aka com.example.alzaraapriliani.zaraproject:color/colorBasic) not found.
C:\Users\saran\StudioProjects\zaraproject\app\src\main\res\layout\activity_project1.xml:57: error: resource color/colorBasic (aka com.example.alzaraapriliani.zaraproject:color/colorBasic) not found.
error: failed linking file resources.
 -  add basic color in colors.xml

colors.xml
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#FFE100</color>
    <color name="colorPrimaryDark">#88000000</color>
    <color name="colorAccent">#FF4081</color>
    <color name="colorBasic">#AEAEAE</color>

</resources>

```

# third error
Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void android.view.View.setOnClickListener(android.view.View$OnClickListener)' on a null object reference
        at com.example.alzaraapriliani.zaraproject.project2.onCreate(project2.java:22)
        at android.app.Activity.performCreate(Activity.java:7698)
        at android.app.Activity.performCreate(Activity.java:7687)
        at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1299)

- nothing id "spinner"
- spinner part comment
project2.java
```
public class project2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project2);

        /*findViewById(R.id.spinner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project2.this, RegionSelectActivity.class);
                startActivity(intent);


            }
        });*/

        findViewById(R.id.btnprofile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project2.this, profilemain.class);
                startActivity(intent);

            }
        });

        findViewById(R.id.notif).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(project2.this, notifikasion.class);
                startActivity(intent);

            }
        });

    }
}

```