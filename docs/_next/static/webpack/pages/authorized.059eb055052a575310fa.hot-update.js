webpackHotUpdate_N_E("pages/authorized",{

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

  var called = false;
  Object(react__WEBPACK_IMPORTED_MODULE_2__["useEffect"])(function () {
    if (!called && token) {
      called = true;
      fetchUser();
    }
  });

  var handleLogin = function handleLogin(jwt) {
    cookies.set('jwt', jwt, {
      path: '/',
      maxAge: 60 * 60 * 24 * 30,
      // 30 days
      sameSite: 'lax'
    });
    setToken(jwt);
  };

  var handleLogout = function handleLogout() {
    cookies.remove('jwt');
    setUser(undefined);
    setToken(undefined);
  };

  var handleRequest = function handleRequest(route, options) {
    return axios__WEBPACK_IMPORTED_MODULE_4___default.a.get("http://localhost:8080".concat(route), _objectSpread({
      headers: {
        Authorization: "Bearer ".concat(token)
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
    token: token,
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
    lineNumber: 65,
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
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9fTl9FLy4vc3JjL2NvbXBvbmVudHMvQXV0aFByb3ZpZGVyLmpzIl0sIm5hbWVzIjpbIkF1dGhDb250ZXh0IiwiY3JlYXRlQ29udGV4dCIsImNvb2tpZXMiLCJDb29raWVzIiwiQXV0aFByb3ZpZGVyIiwiY2hpbGRyZW4iLCJ1c2VTdGF0ZSIsInRva2VuIiwic2V0VG9rZW4iLCJ1c2VyIiwic2V0VXNlciIsImNhbGxlZCIsInVzZUVmZmVjdCIsImZldGNoVXNlciIsImhhbmRsZUxvZ2luIiwiand0Iiwic2V0IiwicGF0aCIsIm1heEFnZSIsInNhbWVTaXRlIiwiaGFuZGxlTG9nb3V0IiwicmVtb3ZlIiwidW5kZWZpbmVkIiwiaGFuZGxlUmVxdWVzdCIsInJvdXRlIiwib3B0aW9ucyIsImF4aW9zIiwiZ2V0IiwiaGVhZGVycyIsIkF1dGhvcml6YXRpb24iLCJ0aGVuIiwicmVzcG9uc2UiLCJkYXRhIiwiZXJyb3IiLCJjb25zb2xlIiwibG9nIiwic3RhdHVzIiwiY29udGV4dCIsInVzZUF1dGgiLCJ1c2VDb250ZXh0Il0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFBQTtBQUNBO0FBQ0E7QUFFQSxJQUFNQSxXQUFXLGdCQUFHQywyREFBYSxFQUFqQztBQUNBLElBQU1DLE9BQU8sR0FBRyxJQUFJQyx3REFBSixFQUFoQjs7QUFFQSxJQUFNQyxZQUFZLEdBQUcsU0FBZkEsWUFBZSxPQUFrQjtBQUFBOztBQUFBLE1BQWZDLFFBQWUsUUFBZkEsUUFBZTs7QUFBQSxrQkFDWEMsc0RBQVEsRUFERztBQUFBLE1BQzlCQyxLQUQ4QjtBQUFBLE1BQ3ZCQyxRQUR1Qjs7QUFBQSxtQkFFYkYsc0RBQVEsRUFGSztBQUFBLE1BRTlCRyxJQUY4QjtBQUFBLE1BRXhCQyxPQUZ3Qjs7QUFHckMsTUFBSUMsTUFBTSxHQUFHLEtBQWI7QUFFQUMseURBQVMsQ0FBQyxZQUFNO0FBQ2QsUUFBSSxDQUFDRCxNQUFELElBQVdKLEtBQWYsRUFBc0I7QUFDcEJJLFlBQU0sR0FBRyxJQUFUO0FBQ0FFLGVBQVM7QUFDVjtBQUNGLEdBTFEsQ0FBVDs7QUFPQSxNQUFNQyxXQUFXLEdBQUcsU0FBZEEsV0FBYyxDQUFDQyxHQUFELEVBQVM7QUFDM0JiLFdBQU8sQ0FBQ2MsR0FBUixDQUFZLEtBQVosRUFBbUJELEdBQW5CLEVBQXdCO0FBQ3RCRSxVQUFJLEVBQUUsR0FEZ0I7QUFFdEJDLFlBQU0sRUFBRSxLQUFLLEVBQUwsR0FBVSxFQUFWLEdBQWUsRUFGRDtBQUVLO0FBQzNCQyxjQUFRLEVBQUU7QUFIWSxLQUF4QjtBQUtBWCxZQUFRLENBQUNPLEdBQUQsQ0FBUjtBQUNELEdBUEQ7O0FBU0EsTUFBTUssWUFBWSxHQUFHLFNBQWZBLFlBQWUsR0FBTTtBQUN6QmxCLFdBQU8sQ0FBQ21CLE1BQVIsQ0FBZSxLQUFmO0FBQ0FYLFdBQU8sQ0FBQ1ksU0FBRCxDQUFQO0FBQ0FkLFlBQVEsQ0FBQ2MsU0FBRCxDQUFSO0FBQ0QsR0FKRDs7QUFNQSxNQUFNQyxhQUFhLEdBQUcsU0FBaEJBLGFBQWdCLENBQUNDLEtBQUQsRUFBUUMsT0FBUixFQUFvQjtBQUN4QyxXQUFPQyw0Q0FBSyxDQUFDQyxHQUFOLGdDQUFrQ0gsS0FBbEM7QUFDTEksYUFBTyxFQUFFO0FBQ1BDLHFCQUFhLG1CQUFZdEIsS0FBWjtBQUROO0FBREosT0FJRmtCLE9BSkUsRUFBUDtBQU1ELEdBUEQ7O0FBU0EsTUFBTVosU0FBUyxHQUFHLFNBQVpBLFNBQVksR0FBTTtBQUN0QlUsaUJBQWEsQ0FBQyxPQUFELENBQWIsQ0FDR08sSUFESCxDQUNRLFVBQUNDLFFBQUQsRUFBYztBQUNsQnJCLGFBQU8sQ0FBQ3FCLFFBQVEsQ0FBQ0MsSUFBVixDQUFQO0FBQ0QsS0FISCxXQUlTLFVBQUNDLEtBQUQsRUFBVztBQUFBOztBQUNoQkMsYUFBTyxDQUFDQyxHQUFSLENBQVlGLEtBQVo7O0FBQ0EsVUFBSSxDQUFBQSxLQUFLLFNBQUwsSUFBQUEsS0FBSyxXQUFMLDJCQUFBQSxLQUFLLENBQUVELElBQVAsNERBQWFJLE1BQWIsS0FBdUIsR0FBM0IsRUFBZ0M7QUFDOUJoQixvQkFBWTtBQUNiO0FBQ0YsS0FUSDtBQVVELEdBWEQ7O0FBYUEsTUFBTWlCLE9BQU8sR0FBRztBQUNkOUIsU0FBSyxFQUFMQSxLQURjO0FBRWRFLFFBQUksRUFBSkEsSUFGYztBQUdkSyxlQUFXLEVBQVhBLFdBSGM7QUFJZE0sZ0JBQVksRUFBWkEsWUFKYztBQUtkRyxpQkFBYSxFQUFiQTtBQUxjLEdBQWhCO0FBUUEsc0JBQU8scUVBQUMsV0FBRCxDQUFhLFFBQWI7QUFBc0IsU0FBSyxFQUFFYyxPQUE3QjtBQUFBLGNBQXVDaEM7QUFBdkM7QUFBQTtBQUFBO0FBQUE7QUFBQSxXQUFQO0FBQ0QsQ0ExREQ7O0dBQU1ELFk7O0tBQUFBLFk7O0FBNEROLElBQU1rQyxPQUFPLEdBQUcsU0FBVkEsT0FBVTtBQUFBOztBQUFBLFNBQU1DLHdEQUFVLENBQUN2QyxXQUFELENBQWhCO0FBQUEsQ0FBaEI7O0lBQU1zQyxPOztBQUVOIiwiZmlsZSI6InN0YXRpYy93ZWJwYWNrL3BhZ2VzL2F1dGhvcml6ZWQuMDU5ZWIwNTUwNTJhNTc1MzEwZmEuaG90LXVwZGF0ZS5qcyIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7IHVzZVN0YXRlLCBjcmVhdGVDb250ZXh0LCB1c2VDb250ZXh0LCB1c2VFZmZlY3QgfSBmcm9tICdyZWFjdCdcbmltcG9ydCBDb29raWVzIGZyb20gJ3VuaXZlcnNhbC1jb29raWUnXG5pbXBvcnQgYXhpb3MgZnJvbSAnYXhpb3MnXG5cbmNvbnN0IEF1dGhDb250ZXh0ID0gY3JlYXRlQ29udGV4dCgpXG5jb25zdCBjb29raWVzID0gbmV3IENvb2tpZXMoKVxuXG5jb25zdCBBdXRoUHJvdmlkZXIgPSAoeyBjaGlsZHJlbiB9KSA9PiB7XG4gIGNvbnN0IFt0b2tlbiwgc2V0VG9rZW5dID0gdXNlU3RhdGUoKVxuICBjb25zdCBbdXNlciwgc2V0VXNlcl0gPSB1c2VTdGF0ZSgpXG4gIGxldCBjYWxsZWQgPSBmYWxzZVxuXG4gIHVzZUVmZmVjdCgoKSA9PiB7XG4gICAgaWYgKCFjYWxsZWQgJiYgdG9rZW4pIHtcbiAgICAgIGNhbGxlZCA9IHRydWVcbiAgICAgIGZldGNoVXNlcigpXG4gICAgfVxuICB9KVxuXG4gIGNvbnN0IGhhbmRsZUxvZ2luID0gKGp3dCkgPT4ge1xuICAgIGNvb2tpZXMuc2V0KCdqd3QnLCBqd3QsIHtcbiAgICAgIHBhdGg6ICcvJyxcbiAgICAgIG1heEFnZTogNjAgKiA2MCAqIDI0ICogMzAsIC8vIDMwIGRheXNcbiAgICAgIHNhbWVTaXRlOiAnbGF4JyxcbiAgICB9KVxuICAgIHNldFRva2VuKGp3dClcbiAgfVxuXG4gIGNvbnN0IGhhbmRsZUxvZ291dCA9ICgpID0+IHtcbiAgICBjb29raWVzLnJlbW92ZSgnand0JylcbiAgICBzZXRVc2VyKHVuZGVmaW5lZClcbiAgICBzZXRUb2tlbih1bmRlZmluZWQpXG4gIH1cblxuICBjb25zdCBoYW5kbGVSZXF1ZXN0ID0gKHJvdXRlLCBvcHRpb25zKSA9PiB7XG4gICAgcmV0dXJuIGF4aW9zLmdldChgaHR0cDovL2xvY2FsaG9zdDo4MDgwJHtyb3V0ZX1gLCB7XG4gICAgICBoZWFkZXJzOiB7XG4gICAgICAgIEF1dGhvcml6YXRpb246IGBCZWFyZXIgJHt0b2tlbn1gLFxuICAgICAgfSxcbiAgICAgIC4uLm9wdGlvbnMsXG4gICAgfSlcbiAgfVxuXG4gIGNvbnN0IGZldGNoVXNlciA9ICgpID0+IHtcbiAgICBoYW5kbGVSZXF1ZXN0KCcvdXNlcicpXG4gICAgICAudGhlbigocmVzcG9uc2UpID0+IHtcbiAgICAgICAgc2V0VXNlcihyZXNwb25zZS5kYXRhKVxuICAgICAgfSlcbiAgICAgIC5jYXRjaCgoZXJyb3IpID0+IHtcbiAgICAgICAgY29uc29sZS5sb2coZXJyb3IpXG4gICAgICAgIGlmIChlcnJvcj8uZGF0YT8uc3RhdHVzID49IDQwMCkge1xuICAgICAgICAgIGhhbmRsZUxvZ291dCgpXG4gICAgICAgIH1cbiAgICAgIH0pXG4gIH1cblxuICBjb25zdCBjb250ZXh0ID0ge1xuICAgIHRva2VuLFxuICAgIHVzZXIsXG4gICAgaGFuZGxlTG9naW4sXG4gICAgaGFuZGxlTG9nb3V0LFxuICAgIGhhbmRsZVJlcXVlc3QsXG4gIH1cblxuICByZXR1cm4gPEF1dGhDb250ZXh0LlByb3ZpZGVyIHZhbHVlPXtjb250ZXh0fT57Y2hpbGRyZW59PC9BdXRoQ29udGV4dC5Qcm92aWRlcj5cbn1cblxuY29uc3QgdXNlQXV0aCA9ICgpID0+IHVzZUNvbnRleHQoQXV0aENvbnRleHQpXG5cbmV4cG9ydCB7IEF1dGhQcm92aWRlciwgdXNlQXV0aCB9XG4iXSwic291cmNlUm9vdCI6IiJ9