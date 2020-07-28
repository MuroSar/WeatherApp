# Weather App

## Kotlin + MVVM + Clean Architecture + Dagger - Hilt + Coroutines
To do the project Kotlin was used as a programming language and MVVM (Model - View - ViewModel) as a software architectural pattern.

## MVVM (Model - View - ViewModel):
The Model View ViewModel pattern helps with the separation of concerns, dividing the user interface with the logic behind. The decision to use this pattern is mainly based on the support Google has been giving to it. Moreover, MVVM is vastly used in today’s Android development and combines very well with Android Architecture Components like LiveData and DataBindings.

* Model: As we are implementing MVVM with Clean Architecture, we decided not to have a Model class, the ViewModel interacts directly with the domain, utilizing the use cases. This kind of implementation is named "ViewModel centric".
* View: The view in our implementation of MVVM is actually a Fragment or an Activity. The views enclose everything needed to handle the user interface. They observe the ViewModel, using LiveData components, and react to its changes as they need to.
* ViewModel: The responsable of the relationship between the data and the user interface of the application. The ViewModel has the logic to convert what the use cases provide into information that the view can understand and present. Furthermore, it has the responsability and the logic to react to the user’s input, and call the necessary use cases. The most useful of the Android’s ViewModel class is its lifecycle consciousness. It only communicates to the View with LiveData components, so it does not need a reference to a contexts or an activity: it can keep the information alive even against configuration changes like screen rotations or calls to background.
alt text

If you want to read and understad at all MVVM, just visit: https://docs.google.com/presentation/d/1JkepsjABKhOmQr7bc62mL8vd-3UqbyklceHfJn4K0rU/edit?ts=5daa0000#slide=id.g61baf37ef4_1_33

## Clean Architecture:
Clean architecture attempts to provide a methodology to use in coding in order to make it easier to develop quality code that performs better is easier to change, update and has fewer dependencies. An important goal of clean architecture is to provide developers with a way to organize code in such a way that it encapsulates the business logic but keeps it separate from the delivery mechanism.

Layers of Clean Architecture used in this project:

* Domain: Would execute business logic which is independent of any layer and is just a pure kotlin package with no android specific dependency.
* Data: Would dispense the required data for the application to the domain layer by implementing interface exposed by the domain.
* Presentation: Would include both domain and data layer and is android specific which executes the UI logic.
alt text

To learn about different ways of implement Clean Architecture, visit: https://docs.google.com/presentation/d/1aBtccGraTyggnIP6Nn7m8uGfBgreKWIk-2JuLafKAds/edit#slide=id.p4

## Dependency Injection - Dagger - Hilt: 
Dependency injection is a programming technique that makes a class independent of its dependencies by decoupling the usage of an object from its creation. It’s derived from the fifth principle of the famous object-oriented programming principles S.O.L.I.D (Dependency Inversion: a class should concentrate on fulfilling its own responsibilities and should not be concerned with creating objects to fulfill those responsibilities). This layer was implemented using **Hilt**.

All apps that use Hilt must contain an Application class that is annotated with **@HiltAndroidApp.**
**@HiltAndroidApp** triggers Hilt's code generation, including a base class for your application that serves as the application-level dependency container.
```
@HiltAndroidApp
class BaseApplication : Application()
```

Once Hilt is set up in your Application class and an application-level component is available, Hilt can provide dependencies to other Android classes that have the **@AndroidEntryPoint** annotation:
```
@AndroidEntryPoint
class Activity: AppCompatActivity()
```
the way to inject view models is using the annotation **@ViewModelInject** in the ViewModel constructor like this: 

`class ViewModel @ViewModelInject constructor()` or `class ViewModel @ViewModelInject constructor(private val someUseCase: SomeUseCase) `

So then in the activity, we are going to inject ViewModel using by viewModels() as you can see in the next line:
```
@AndroidEntryPoint
class Activity: AppCompatActivity() {
    ...
    private val viewModel: ViewModel by viewModels() 
 
   ...
}
```

Now we need to say Hilt if we have ViewModel constructor not empty how can get that implementation(that is in the domain layer), so we are going to create a Module using the annotation **@Module** and have something like this: 
```
@Module
object DomainModule {
   @Provides
   fun providesSomeUseCase(someService: SomeService): SomeUseCase = SomeUseCaseImpl(someService)
}
```
In the Data module layer, we are going to do the same with someService: 
```
@Module
object DataModule {
    @Singleton
    @Provides
    fun provideService(): SomeService = SomeServiceImpl()
}
```

Finally, we need to know at the app module how to get that dependency so we are going to create the app module
```
@InstallIn(ApplicationComponent::class)
@Module(includes = [DataModule::class, DomainModule::class])
object AppModule
```

## Coroutines:
Coroutines are a new way of managing background threads that can simplify code by reducing the need for callbacks. They convert async callbacks for long-running tasks, such as a database or network access, into sequential code. We use coroutines to do tasks in a background thread. The guideline should be that every task executed in a coroutine should be done in a background thread and the UI doesn’t get blocked.

Job: a job is a cancellable task with a life-cycle that culminates in its completion. By default, a failure of any of the job’s children leads to an immediate failure of its parent and cancellation of the rest of its children.

Dispatchers:

* Dispatchers.Default – is used by all standard builders by default. It uses a common pool of shared background threads. This is an appropriate choice for compute-intensive coroutines that consume CPU resources.
* Dispatchers.IO – uses a shared pool of on-demand created threads and is designed for offloading of IO-intensive blocking operations (like file I/O and blocking socket I/O).
