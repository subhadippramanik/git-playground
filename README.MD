# git-playground

This is a sample project to learn basic features of git and get used to with the commands.

## know your repository
###### While working with git, we must maintain git flow. Which essentially means, there will 2 default branches `master` and `develop`. For any new feature development or bug fix we will clone `develop`. We check in the new changes to the newly created feature branch. We review or validate the changes and merge it to `develop`. Once `develop` has that code we again re-check/re-validate and run our tests and then finally promote the `develop` to `master`. So we make sure our `develop` always has latest working code, which may not be stable and `master` always has stable code which may not be latest.


### getting started

  - Go to a project root directory on PC. example `D:\my-projects`
  - right click and open git bash
  - Run command 
```sh 
git clone https://github.com/subhadippramanik/git-playground.git
``` 
  - now you will see a project directory `git-playground` under your project root directory
  - so you have checked out `develop` branch now
