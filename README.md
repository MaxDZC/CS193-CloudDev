# HealthPlus
------
## Getting Started
1. Download v6.11.0 LTS of [NodeJS][node]
2. Inside the **Node.js Command Prompt**, change the current directory to the `healthplus` directory located in `war/healthplus`.
3. Type in `npm install`.
---   ---

## Are you working already and want to see your changes in HTML/CSS/JS?  
Don't forget to type in `webpack` in the `healthplus` directory using the command prompt or Git Bash. 
If you want it to automatically compile for you, type in `webpack --watch`.

------

## Directory Structure
```
app/                                    --> Contains the source code
    components/                         --> Contains all the features, 
                                            separated by "module"
        explorediseases/                --> A module named "Explore Diseases"
            explorediseases.html        --> The view for this module
            explorediseases.main.js     --> The JS file for the module that 
                                            connects the directives (not available yet),
                                            controllers (not available yet) and 
                                            routes for this module.
    shared/                             --> Contains all shared modules
        header/                         --> A shared module named "Header"
            _header.scss                --> The stylesheet related to this module
            header.directive.js         --> The directives used in this module
            header.html                 --> The view for this module
            header.main.js              --> The JS file for the module that connects 
                                            directives, controllers (not available yet)
                                            and routes for this module (not applicable).
        navbar/                         --> A shared module named "Navbar"
            _navbar.scss
            navbar.directive.js
            navbar.html
            navbar.main.js
        scss/                           --> All shared stylesheets
            vendor/                     --> Folder for all stylesheets downloaded 
                                            from the internet
            _base.scss                  --> Stylesheet for anywhere
            _card.scss                  --> Stylesheet for cards
            _colors.scss                --> Stylesheet for colors
            _input.scss                 --> Stylesheet for input fields & buttons
            _sizes.scss                 --> Stylesheet for sizes
            _typography.scss            --> Stylesheet for fonts
    app.js                              --> The main AngularJS code which makes
                                            this a single-page app.
    app.module.js                       --> A dependency that connects app.js
                                            and all other modules.
assets/                                 --> Other useful stuff that we'll need (like images)
    main.scss                           --> Houses the locations for all stylesheets
dist/                                   --> Folder to be exposed to the public
    fonts/
    app.bundle.js                       --> Minified code containing all HTML 
                                            views, CSS styles and Javascript files.
index.html                              --> Angular-ized website.
index_orig.html                         --> Original website. Might be broken.
package.json                            --> File that makes npm recognize its dependencies
webpack.config.js                       --> File that makes Webpack do its job well
```

------

## How to run the thing in Eclipse
1. Use the eclipse sir gave us and follow his [instructions][instruction].
2. If you haven't followed the Getting Started instructions and webpacked, do it now.
3. Run it as a Web Application. (looks like a blue google 'g' symbol)
4. That's really all there is to it. To see the thing: `http://localhost:8888/healthplus/`

------

## But how do I look at the module I made??
```
    components/                         
        explorediseases/                
            explorediseases.html        
            explorediseases.main.js     
        mymodule/                
            mymodule.html        
            mymodule.main.js   
    app.module.js     
```

1. Inside `mymodule.main.js`
```
var mymodule = require('html-loader!./mymodule.html');

angular.module('hplus.modules.mymodule', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/urlforyourmodule',{
        template: mymodule
      })
  });

```

2. Inside `app.module.js` add
```
require('./components/mymodule/mymodule.main.js');
```

3. weebpack and run the thing. Your module url: `http://localhost:8888/healthplus/#!/urlforyourmodule`

------

## Still can't see your module? 
Empty Cache and Hard Reload (for Google Chrome (idk how to do it for other browsers sorry))
1. Right click 
2. Inspect
3. Right Click on reload symbol (swirly arrow upper left)
4. Click on 'Empty Cache and Hard Reload'


[node]: https://nodejs.org/en/
[instruction]: https://drive.google.com/drive/folders/0B9VWiPnJTkPAVWltXzE4VExuVzg
