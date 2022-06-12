# PROJECT_Polski_Punish

#Spring-Data #MySQL #JPA_Repo #DOCKER

Project is used as my MASTER THESIS subject. It provides source code for it's implementation.

The main goal of a project is to create WebSite Ranking based on Tekke 7 game tournaments. 
Administrators have posibility to add data from recent tournaments and get rankings.

Recent Utilities:  
  -Swagger UI enabled
  -CRUD for Tournaments and Their participants  
  -Player list with Offline and Online Rankings (Players are unique and added after adding new tournament with new unique participants)  
  -Added some bonus endpoints like getting certain player tournament data.  
  -Added Dockerfile with Docker Hub repo. It can autobuild images from git.   
  -Adding Tournaments and participants from csv files.  
  -Adding Tournaments and particiapants from challonge.com api.  
  -Adding Tournaments and participants from smash.gg api.  
  -Adding Match predictions using WEKA framework
  -Adding Data conversion methods
  
  next targets:  
  -Learning new tools like mapper, docker.  
  -Handle exceptions,erros. Some data serialization.  
  -Further code improvements. 
  
  Current targets:
  -Changing some model mappers to map structs (Peaople say it's way faster)
  -Adding new exceptions (Checking out the best practices)
  -Changing models. Refreshing code. 
  
  
  
