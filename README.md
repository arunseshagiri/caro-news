
# caro-news
* A simple app to read the news from backend and display it in a card view.
* Sort the articles based on the time creation by default
* When user selects “recent” sorting option from actionbar menu, display the list sorted by the time
* “Popular” option should prioritize the articles first based on the rank and then the time
* Link to the news: https://raw.githubusercontent.com/arunseshagiri/caro-news/master/news.json
* MVVM design pattern
* OkHttp and Retrofit, Gson converter to make API calls and convert JSON to POJO objects
* RxJava & RxAndroid
* Dependency Injection with Dagger 2 
* Implemented code in Kotlin
* Picasso to download images from server and display it on RecyclerView, 
* Timber for logging
* Date of creation displayed in a readable format, that shows timespan relative to current time. Achieved using PrettyTime library.
  Example: 
  + 5 days ago > “5 days ago”
  + 7 days ago > “1 week ago”
  + 4 weeks ago > “1 month ago”
  + 12 months ago > “1 year ago”
  
