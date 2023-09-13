# KotlinCalculatorIMC

Esta aplicación te permite calcular tu Índice de Masa Corporal (IMC), que es una medida que indica si tu peso es saludable en relación con tu altura. Para utilizarla, ingresas tu peso actual, edad y altura, y la aplicación calcula tu IMC automáticamente. Luego, te muestra en qué categoría de peso te encuentras, como bajo peso, peso normal, sobrepeso u obesidad. Además, puedes cambiar tu género entre masculino y femenino en la aplicación. ¡Es una herramienta útil para mantener un estilo de vida saludable!

En `MainActivity`:

1. Se declaran variables para almacenar información como el género seleccionado (masculino o femenino), el peso actual, la edad actual y la altura actual.

2. Se declaran variables `lateinit` para representar varios elementos de la interfaz de usuario, como tarjetas, botones y etiquetas de texto.

3. Se define una constante `IMC_KEY` que se utilizará para pasar el resultado del IMC entre actividades.

4. En el método `onCreate`, se inicializan todos los componentes de la interfaz de usuario llamando a la función `initComponent()`, se configuran los listeners llamando a la función `initListeners()`, y se realiza alguna configuración adicional de la interfaz de usuario mediante `initUI()`.

5. `initComponent()` asigna los elementos de la interfaz de usuario a las variables correspondientes.

6. `initListeners()` configura los listeners para los elementos de la interfaz de usuario, como los botones y las tarjetas. También actualiza los valores de peso, edad y altura cuando se hacen cambios en la interfaz de usuario.

7. `calculateImc()` calcula el IMC en función del peso, la altura y la edad actuales y devuelve el resultado.

8. `setWeight()` y `setAge()` actualizan las etiquetas de texto en la interfaz de usuario con los valores de peso y edad actuales.

9. `changeGender()` cambia el género seleccionado entre masculino y femenino.

10. `setGenderBackground()` cambia el color de fondo de las tarjetas de género según el género seleccionado.

### En `ResultActivity`:

1. Esta actividad muestra el resultado del cálculo del IMC y proporciona información sobre la categoría de peso.

2. `initComponents()` inicializa los elementos de la interfaz de usuario.

3. `initUI(result)` muestra el resultado del IMC en un TextView y determina la categoría de peso en función del valor del IMC. Luego, cambia el color del texto y muestra una descripción de la categoría.

4. `initListeners()` configura un listener para el botón "ReCalcular", que permite al usuario volver a la actividad anterior.


![bajo-peso](https://github.com/GuidiUZ/KotlinCalculatorIMC/assets/83031656/01f0b390-82e9-4c2b-9cb6-81b934523eab)
![bajo-peso-resultado](https://github.com/GuidiUZ/KotlinCalculatorIMC/assets/83031656/30d0d1d5-3617-4c16-bfe3-8a4f5417b0f1)
![normal-peso-resultado](https://github.com/GuidiUZ/KotlinCalculatorIMC/assets/83031656/f19e94cc-a6de-42a1-8542-8a4adc8b543c)
![sobre-peso-resultado](https://github.com/GuidiUZ/KotlinCalculatorIMC/assets/83031656/c74f6d0b-59ab-4979-a941-b0fdc00da59f)
![obesidad-resultado](https://github.com/GuidiUZ/KotlinCalculatorIMC/assets/83031656/deea0321-cfdc-4311-a7ea-4d50c89f4e46)



