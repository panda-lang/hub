webpackHotUpdate_N_E("pages/index",{

/***/ "./src/components/AuthProvider.js":
/*!****************************************!*\
  !*** ./src/components/AuthProvider.js ***!
  \****************************************/
/*! exports provided: AuthProvider, useAuth */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* WEBPACK VAR INJECTION */(function(module) {/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthProvider", function() { return AuthProvider; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "useAuth", function() { return useAuth; });
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react/jsx-dev-runtime */ "./node_modules/react/jsx-dev-runtime.js");
/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/esm/defineProperty */ "./node_modules/@babel/runtime/helpers/esm/defineProperty.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_2__);
/* harmony import */ var universal_cookie__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! universal-cookie */ "./node_modules/universal-cookie/es6/index.js");
/* harmony import */ var axios__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! axios */ "./node_modules/axios/index.js");
/* harmony import */ var axios__WEBPACK_IMPORTED_MODULE_4___default = /*#__PURE__*/__webpack_require__.n(axios__WEBPACK_IMPORTED_MODULE_4__);



var _jsxFileName = "J:\\Java\\Spring\\hub\\hub-frontend\\src\\components\\AuthProvider.js",
    _this = undefined,
    _s = $RefreshSig$(),
    _s2 = $RefreshSig$();

function ownKeys(object, enumerableOnly) { var keys = Object.keys(object); if (Object.getOwnPropertySymbols) { var symbols = Object.getOwnPropertySymbols(object); if (enumerableOnly) symbols = symbols.filter(function (sym) { return Object.getOwnPropertyDescriptor(object, sym).enumerable; }); keys.push.apply(keys, symbols); } return keys; }

function _objectSpread(target) { for (var i = 1; i < arguments.length; i++) { var source = arguments[i] != null ? arguments[i] : {}; if (i % 2) { ownKeys(Object(source), true).forEach(function (key) { Object(J_Java_Spring_hub_hub_frontend_node_modules_babel_runtime_helpers_esm_defineProperty__WEBPACK_IMPORTED_MODULE_1__["default"])(target, key, source[key]); }); } else if (Object.getOwnPropertyDescriptors) { Object.defineProperties(target, Object.getOwnPropertyDescriptors(source)); } else { ownKeys(Object(source)).forEach(function (key) { Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key)); }); } } return target; }




var AuthContext = /*#__PURE__*/Object(react__WEBPACK_IMPORTED_MODULE_2__["createContext"])();
var cookies = new universal_cookie__WEBPACK_IMPORTED_MODULE_3__["default"]();

var AuthProvider = function AuthProvider(_ref) {
  _s();

  var children = _ref.children;

  var _useState = Object(react__WEBPACK_IMPORTED_MODULE_2__["useState"])(),
      token = _useState[0],
      setToken = _useState[1];

  var _useState2 = Object(react__WEBPACK_IMPORTED_MODULE_2__["useState"])(),
      user = _useState2[0],
      setUser = _useState2[1];

  Object(react__WEBPACK_IMPORTED_MODULE_2__["useEffect"])(function () {
    if (getJwt()) {
      fetchUser();
    }
  });

  var getJwt = function getJwt() {
    return cookies.get('jwt');
  };

  var handleLogin = function handleLogin(jwt) {
    console.log('set ' + jwt);
    cookies.set('jwt', jwt, {
      path: '/',
      maxAge: 60 * 60 * 24 * 30,
      // 30 days
      sameSite: 'lax'
    });
  };

  var handleLogout = function handleLogout() {
    console.log('remove ');
    cookies.remove('jwt');
    setUser(undefined);
  };

  var handleRequest = function handleRequest(route, options) {
    return axios__WEBPACK_IMPORTED_MODULE_4___default.a.get("http://localhost:8080".concat(route), _objectSpread({
      headers: {
        Authorization: "Bearer ".concat(getJwt())
      }
    }, options));
  };

  var fetchUser = function fetchUser() {
    handleRequest('/user').then(function (response) {
      setUser(response.data);
    })["catch"](function (error) {
      var _error$data;

      console.log(error);

      if ((error === null || error === void 0 ? void 0 : (_error$data = error.data) === null || _error$data === void 0 ? void 0 : _error$data.status) >= 400) {
        handleLogout();
      }
    });
  };

  var context = {
    getJwt: getJwt,
    user: user,
    handleLogin: handleLogin,
    handleLogout: handleLogout,
    handleRequest: handleRequest
  };
  return /*#__PURE__*/Object(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__["jsxDEV"])(AuthContext.Provider, {
    value: context,
    children: children
  }, void 0, false, {
    fileName: _jsxFileName,
    lineNumber: 67,
    columnNumber: 10
  }, _this);
};

_s(AuthProvider, "NBHE/9HkjsDSVFH75XjEPQ1DHtc=");

_c = AuthProvider;

var useAuth = function useAuth() {
  _s2();

  return Object(react__WEBPACK_IMPORTED_MODULE_2__["useContext"])(AuthContext);
};

_s2(useAuth, "gDsCjeeItUuvgOWf1v4qoK9RF6k=");



var _c;

$RefreshReg$(_c, "AuthProvider");

;
    var _a, _b;
    // Legacy CSS implementations will `eval` browser code in a Node.js context
    // to extract CSS. For backwards compatibility, we need to check we're in a
    // browser context before continuing.
    if (typeof self !== 'undefined' &&
        // AMP / No-JS mode does not inject these helpers:
        '$RefreshHelpers$' in self) {
        var currentExports = module.__proto__.exports;
        var prevExports = (_b = (_a = module.hot.data) === null || _a === void 0 ? void 0 : _a.prevExports) !== null && _b !== void 0 ? _b : null;
        // This cannot happen in MainTemplate because the exports mismatch between
        // templating and execution.
        self.$RefreshHelpers$.registerExportsForReactRefresh(currentExports, module.i);
        // A module can be accepted automatically based on its exports, e.g. when
        // it is a Refresh Boundary.
        if (self.$RefreshHelpers$.isReactRefreshBoundary(currentExports)) {
            // Save the previous exports on update so we can compare the boundary
            // signatures.
            module.hot.dispose(function (data) {
                data.prevExports = currentExports;
            });
            // Unconditionally accept an update to this module, we'll check if it's
            // still a Refresh Boundary later.
            module.hot.accept();
            // This field is set when the previous version of this module was a
            // Refresh Boundary, letting us know we need to check for invalidation or
            // enqueue an update.
            if (prevExports !== null) {
                // A boundary can become ineligible if its exports are incompatible
                // with the previous exports.
                //
                // For example, if you add/remove/change exports, we'll want to
                // re-execute the importing modules, and force those components to
                // re-render. Similarly, if you convert a class component to a
                // function, we want to invalidate the boundary.
                if (self.$RefreshHelpers$.shouldInvalidateReactRefreshBoundary(prevExports, currentExports)) {
                    module.hot.invalidate();
                }
                else {
                    self.$RefreshHelpers$.scheduleUpdate();
                }
            }
        }
        else {
            // Since we just executed the code for the module, it's possible that the
            // new exports made it ineligible for being a boundary.
            // We only care about the case when we were _previously_ a boundary,
            // because we already accepted this update (accidental side effect).
            var isNoLongerABoundary = prevExports !== null;
            if (isNoLongerABoundary) {
                module.hot.invalidate();
            }
        }
    }

/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./../../node_modules/next/dist/compiled/webpack/harmony-module.js */ "./node_modules/next/dist/compiled/webpack/harmony-module.js")(module)))

/***/ })

})
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vc3JjL2NvbXBvbmVudHMvQXV0aFByb3ZpZGVyLmpzIl0sIm5hbWVzIjpbIkF1dGhDb250ZXh0IiwiY3JlYXRlQ29udGV4dCIsImNvb2tpZXMiLCJDb29raWVzIiwiQXV0aFByb3ZpZGVyIiwiY2hpbGRyZW4iLCJ1c2VTdGF0ZSIsInRva2VuIiwic2V0VG9rZW4iLCJ1c2VyIiwic2V0VXNlciIsInVzZUVmZmVjdCIsImdldEp3dCIsImZldGNoVXNlciIsImdldCIsImhhbmRsZUxvZ2luIiwiand0IiwiY29uc29sZSIsImxvZyIsInNldCIsInBhdGgiLCJtYXhBZ2UiLCJzYW1lU2l0ZSIsImhhbmRsZUxvZ291dCIsInJlbW92ZSIsInVuZGVmaW5lZCIsImhhbmRsZVJlcXVlc3QiLCJyb3V0ZSIsIm9wdGlvbnMiLCJheGlvcyIsImhlYWRlcnMiLCJBdXRob3JpemF0aW9uIiwidGhlbiIsInJlc3BvbnNlIiwiZGF0YSIsImVycm9yIiwic3RhdHVzIiwiY29udGV4dCIsInVzZUF1dGgiLCJ1c2VDb250ZXh0Il0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQUNBO0FBQ0E7QUFFQSxJQUFNQSxXQUFXLGdCQUFHQywyREFBYSxFQUFqQztBQUNBLElBQU1DLE9BQU8sR0FBRyxJQUFJQyx3REFBSixFQUFoQjs7QUFFQSxJQUFNQyxZQUFZLEdBQUcsU0FBZkEsWUFBZSxPQUFrQjtBQUFBOztBQUFBLE1BQWZDLFFBQWUsUUFBZkEsUUFBZTs7QUFBQSxrQkFDWEMsc0RBQVEsRUFERztBQUFBLE1BQzlCQyxLQUQ4QjtBQUFBLE1BQ3ZCQyxRQUR1Qjs7QUFBQSxtQkFFYkYsc0RBQVEsRUFGSztBQUFBLE1BRTlCRyxJQUY4QjtBQUFBLE1BRXhCQyxPQUZ3Qjs7QUFJckNDLHlEQUFTLENBQUMsWUFBTTtBQUNkLFFBQUlDLE1BQU0sRUFBVixFQUFjO0FBQ1pDLGVBQVM7QUFDVjtBQUNGLEdBSlEsQ0FBVDs7QUFNQSxNQUFNRCxNQUFNLEdBQUcsU0FBVEEsTUFBUyxHQUFNO0FBQ25CLFdBQU9WLE9BQU8sQ0FBQ1ksR0FBUixDQUFZLEtBQVosQ0FBUDtBQUNELEdBRkQ7O0FBSUEsTUFBTUMsV0FBVyxHQUFHLFNBQWRBLFdBQWMsQ0FBQ0MsR0FBRCxFQUFTO0FBQzNCQyxXQUFPLENBQUNDLEdBQVIsQ0FBWSxTQUFTRixHQUFyQjtBQUNBZCxXQUFPLENBQUNpQixHQUFSLENBQVksS0FBWixFQUFtQkgsR0FBbkIsRUFBd0I7QUFDdEJJLFVBQUksRUFBRSxHQURnQjtBQUV0QkMsWUFBTSxFQUFFLEtBQUssRUFBTCxHQUFVLEVBQVYsR0FBZSxFQUZEO0FBRUs7QUFDM0JDLGNBQVEsRUFBRTtBQUhZLEtBQXhCO0FBS0QsR0FQRDs7QUFTQSxNQUFNQyxZQUFZLEdBQUcsU0FBZkEsWUFBZSxHQUFNO0FBQ3pCTixXQUFPLENBQUNDLEdBQVIsQ0FBWSxTQUFaO0FBQ0FoQixXQUFPLENBQUNzQixNQUFSLENBQWUsS0FBZjtBQUNBZCxXQUFPLENBQUNlLFNBQUQsQ0FBUDtBQUNELEdBSkQ7O0FBTUEsTUFBTUMsYUFBYSxHQUFHLFNBQWhCQSxhQUFnQixDQUFDQyxLQUFELEVBQVFDLE9BQVIsRUFBb0I7QUFDeEMsV0FBT0MsNENBQUssQ0FBQ2YsR0FBTixnQ0FBa0NhLEtBQWxDO0FBQ0xHLGFBQU8sRUFBRTtBQUNQQyxxQkFBYSxtQkFBWW5CLE1BQU0sRUFBbEI7QUFETjtBQURKLE9BSUZnQixPQUpFLEVBQVA7QUFNRCxHQVBEOztBQVNBLE1BQU1mLFNBQVMsR0FBRyxTQUFaQSxTQUFZLEdBQU07QUFDdEJhLGlCQUFhLENBQUMsT0FBRCxDQUFiLENBQ0dNLElBREgsQ0FDUSxVQUFDQyxRQUFELEVBQWM7QUFDbEJ2QixhQUFPLENBQUN1QixRQUFRLENBQUNDLElBQVYsQ0FBUDtBQUNELEtBSEgsV0FJUyxVQUFDQyxLQUFELEVBQVc7QUFBQTs7QUFDaEJsQixhQUFPLENBQUNDLEdBQVIsQ0FBWWlCLEtBQVo7O0FBQ0EsVUFBSSxDQUFBQSxLQUFLLFNBQUwsSUFBQUEsS0FBSyxXQUFMLDJCQUFBQSxLQUFLLENBQUVELElBQVAsNERBQWFFLE1BQWIsS0FBdUIsR0FBM0IsRUFBZ0M7QUFDOUJiLG9CQUFZO0FBQ2I7QUFDRixLQVRIO0FBVUQsR0FYRDs7QUFhQSxNQUFNYyxPQUFPLEdBQUc7QUFDZHpCLFVBQU0sRUFBTkEsTUFEYztBQUVkSCxRQUFJLEVBQUpBLElBRmM7QUFHZE0sZUFBVyxFQUFYQSxXQUhjO0FBSWRRLGdCQUFZLEVBQVpBLFlBSmM7QUFLZEcsaUJBQWEsRUFBYkE7QUFMYyxHQUFoQjtBQVFBLHNCQUFPLHFFQUFDLFdBQUQsQ0FBYSxRQUFiO0FBQXNCLFNBQUssRUFBRVcsT0FBN0I7QUFBQSxjQUF1Q2hDO0FBQXZDO0FBQUE7QUFBQTtBQUFBO0FBQUEsV0FBUDtBQUNELENBNUREOztHQUFNRCxZOztLQUFBQSxZOztBQThETixJQUFNa0MsT0FBTyxHQUFHLFNBQVZBLE9BQVU7QUFBQTs7QUFBQSxTQUFNQyx3REFBVSxDQUFDdkMsV0FBRCxDQUFoQjtBQUFBLENBQWhCOztJQUFNc0MsTzs7QUFFTiIsImZpbGUiOiJzdGF0aWMvd2VicGFjay9wYWdlcy9pbmRleC4xMTAzMmE0NGViNmJiNWU0OGVlZS5ob3QtdXBkYXRlLmpzIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgdXNlU3RhdGUsIGNyZWF0ZUNvbnRleHQsIHVzZUNvbnRleHQsIHVzZUVmZmVjdCB9IGZyb20gJ3JlYWN0J1xuaW1wb3J0IENvb2tpZXMgZnJvbSAndW5pdmVyc2FsLWNvb2tpZSdcbmltcG9ydCBheGlvcyBmcm9tICdheGlvcydcblxuY29uc3QgQXV0aENvbnRleHQgPSBjcmVhdGVDb250ZXh0KClcbmNvbnN0IGNvb2tpZXMgPSBuZXcgQ29va2llcygpXG5cbmNvbnN0IEF1dGhQcm92aWRlciA9ICh7IGNoaWxkcmVuIH0pID0+IHtcbiAgY29uc3QgW3Rva2VuLCBzZXRUb2tlbl0gPSB1c2VTdGF0ZSgpXG4gIGNvbnN0IFt1c2VyLCBzZXRVc2VyXSA9IHVzZVN0YXRlKClcblxuICB1c2VFZmZlY3QoKCkgPT4ge1xuICAgIGlmIChnZXRKd3QoKSkge1xuICAgICAgZmV0Y2hVc2VyKClcbiAgICB9XG4gIH0pXG4gIFxuICBjb25zdCBnZXRKd3QgPSAoKSA9PiB7XG4gICAgcmV0dXJuIGNvb2tpZXMuZ2V0KCdqd3QnKVxuICB9XG5cbiAgY29uc3QgaGFuZGxlTG9naW4gPSAoand0KSA9PiB7XG4gICAgY29uc29sZS5sb2coJ3NldCAnICsgand0KVxuICAgIGNvb2tpZXMuc2V0KCdqd3QnLCBqd3QsIHtcbiAgICAgIHBhdGg6ICcvJyxcbiAgICAgIG1heEFnZTogNjAgKiA2MCAqIDI0ICogMzAsIC8vIDMwIGRheXNcbiAgICAgIHNhbWVTaXRlOiAnbGF4JyxcbiAgICB9KVxuICB9XG5cbiAgY29uc3QgaGFuZGxlTG9nb3V0ID0gKCkgPT4ge1xuICAgIGNvbnNvbGUubG9nKCdyZW1vdmUgJylcbiAgICBjb29raWVzLnJlbW92ZSgnand0JylcbiAgICBzZXRVc2VyKHVuZGVmaW5lZClcbiAgfVxuXG4gIGNvbnN0IGhhbmRsZVJlcXVlc3QgPSAocm91dGUsIG9wdGlvbnMpID0+IHtcbiAgICByZXR1cm4gYXhpb3MuZ2V0KGBodHRwOi8vbG9jYWxob3N0OjgwODAke3JvdXRlfWAsIHtcbiAgICAgIGhlYWRlcnM6IHtcbiAgICAgICAgQXV0aG9yaXphdGlvbjogYEJlYXJlciAke2dldEp3dCgpfWAsXG4gICAgICB9LFxuICAgICAgLi4ub3B0aW9ucyxcbiAgICB9KVxuICB9XG5cbiAgY29uc3QgZmV0Y2hVc2VyID0gKCkgPT4ge1xuICAgIGhhbmRsZVJlcXVlc3QoJy91c2VyJylcbiAgICAgIC50aGVuKChyZXNwb25zZSkgPT4ge1xuICAgICAgICBzZXRVc2VyKHJlc3BvbnNlLmRhdGEpXG4gICAgICB9KVxuICAgICAgLmNhdGNoKChlcnJvcikgPT4ge1xuICAgICAgICBjb25zb2xlLmxvZyhlcnJvcilcbiAgICAgICAgaWYgKGVycm9yPy5kYXRhPy5zdGF0dXMgPj0gNDAwKSB7XG4gICAgICAgICAgaGFuZGxlTG9nb3V0KClcbiAgICAgICAgfVxuICAgICAgfSlcbiAgfVxuXG4gIGNvbnN0IGNvbnRleHQgPSB7XG4gICAgZ2V0Snd0LFxuICAgIHVzZXIsXG4gICAgaGFuZGxlTG9naW4sXG4gICAgaGFuZGxlTG9nb3V0LFxuICAgIGhhbmRsZVJlcXVlc3QsXG4gIH1cblxuICByZXR1cm4gPEF1dGhDb250ZXh0LlByb3ZpZGVyIHZhbHVlPXtjb250ZXh0fT57Y2hpbGRyZW59PC9BdXRoQ29udGV4dC5Qcm92aWRlcj5cbn1cblxuY29uc3QgdXNlQXV0aCA9ICgpID0+IHVzZUNvbnRleHQoQXV0aENvbnRleHQpXG5cbmV4cG9ydCB7IEF1dGhQcm92aWRlciwgdXNlQXV0aCB9XG4iXSwic291cmNlUm9vdCI6IiJ9