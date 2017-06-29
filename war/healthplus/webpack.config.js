var webpack = require('webpack');

module.exports = {
  context: __dirname,
  entry: './app/app.js',
  output: {
    path: __dirname,
    filename: './dist/app.bundle.js'
  },
  module: {
    rules:  [
              {
                test: /\.scss$/,
                use:  [
                        {
                            loader: "style-loader" // creates style nodes from JS strings
                        }, {
                            loader: "css-loader" // translates CSS into CommonJS
                        }, {
                            loader: "sass-loader" // compiles Sass to CSS
                        }
                      ]
              },
              {
                test: /\.woff(2)?(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                use:  [
                        {
                            loader: "url-loader?limit=10000&mimetype=application/font-woff"
                        }
                      ]
              },
              {
                test: /\.(ttf|eot|svg)(\?v=[0-9]\.[0-9]\.[0-9])?$/,
                use:  [
                        {
                            loader: "file-loader"
                        }
                      ]
              }
            ]
  }
};